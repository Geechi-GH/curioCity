package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Itinerary> getAllItineraries(int userId) {
        List<Itinerary> myList = new ArrayList<>();
        String sql = "SELECT itinerary_id, title, city_id, user_id, date_of_travel, date_created\n" +
                "\tFROM itinerarys\n" +
                "\tWHERE user_id = ? ;";

        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Itinerary itinerary = mapRowToItinerary(results);
                myList.add(itinerary);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server/database", e);
        }
        return myList;
    }

    @Override
    public Itinerary getItineraryById(int id, int userId) {
        Itinerary itinerary = null;
        final String sql = "SELECT itinerary_id, title, city_id, user_id, date_of_travel, date_created\n" +
                "\tFROM itinerarys\n" +
                "\tWHERE itinerary_id = ? AND user_id = ?;";

        final String landitSql = "\tSELECT landmark_id\n" +
                "\tFROM land_itin_helper\n" +
                "\tWHERE itinerary_id = ? \n" +
                "\tORDER BY sequence;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id, userId);
            if (results.next()) {
                itinerary = mapRowToItinerary(results);
            }
            SqlRowSet newResults = jdbcTemplate.queryForRowSet(landitSql, itinerary.getItineraryId());
            int[] landmarkArray = mapRowToArray(newResults);
            itinerary.setLandmarksArray(landmarkArray);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("We found a null");
        }
        return itinerary;
    }

    @Override
    public Itinerary create(Itinerary itinerary, User user) {
        Itinerary newItinerary = null;
        final String sql = "INSERT INTO itinerarys(title, city_id, user_id, date_of_travel, date_created)\n" +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING itinerary_id;";
        try {
            Integer newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getTitle(), 1,
                    user.getId(), itinerary.getDateOfTravel(), itinerary.getDateCreated());
            newItinerary = getItineraryById(newItineraryId, user.getId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newItinerary;
    }

    @Override
    public Itinerary addingLandmarkToItinerary(int userId, Itinerary itinerary) {

        int[] landmarkArray = itinerary.getLandmarksArray();

        String sql = "INSERT INTO land_itin_helper(\n" +
                "\titinerary_id, landmark_id, sequence)\n" +
                "\tVALUES (?, ?, ?) " +
                "RETURNING itinerary_id;";
        try {
            jdbcTemplate.queryForObject(sql, int.class, itinerary.getItineraryId(), landmarkArray[landmarkArray.length - 1], landmarkArray.length - 1);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return itinerary;
    }

    private Itinerary mapRowToItinerary(SqlRowSet results) {
        final Itinerary itinerary = new Itinerary(
                results.getInt("itinerary_id"),
                results.getString("title"),
                results.getInt("city_id"),
                results.getInt("user_id"),
                results.getDate("date_of_travel").toLocalDate(),
                results.getDate("date_created").toLocalDate());
        return itinerary;
    }

    private int[] mapRowToArray(SqlRowSet results) {
        List<Integer> myList = new ArrayList<>();
        while(results.next()) {
           myList.add( results.getInt("landmark_id"));
        }
        int[] myArray = new int[myList.size()];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = myList.get(i);
        }
        return myArray;
    }
}
