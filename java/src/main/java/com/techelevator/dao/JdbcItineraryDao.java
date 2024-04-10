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
    public Itinerary getItineraryById(int id) {
        Itinerary itinerary = null;
        final String sql = "SELECT itinerary_id, title, city_id, user_id, date_of_travel, date_created\n" +
                "\tFROM itinerarys " +
                "WHERE itinerary_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                itinerary = mapRowToItinerary(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return itinerary;
    }

    @Override
    public Itinerary create(Itinerary itinerary, User user) {
        Itinerary newItinerary = null;
        final String sql = "INSERT INTO itinerarys(title, city_id, user_id, date_of_travel, date_created)\n" +
                "VALUES (?, ?, ?, ?, ?)" +
                "RETURNING itinerary_id;";
        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getTitle(), 1,
                    user.getId(), itinerary.getDateOfTravel(), itinerary.getDateCreated());
            newItinerary = getItineraryById(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newItinerary;
    }

    private Itinerary mapRowToItinerary(SqlRowSet results) {
        final Itinerary itinerary = new Itinerary(
                results.getInt("itinerary_id"),
                results.getString("title"),
                results.getInt("city_id"),
                results.getInt("user_id"),
                results.getDate("date_of_travel").toLocalDate(),
                results.getDate("date_created").toLocalDate()
        );
        return itinerary;
    }
}
