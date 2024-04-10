package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcItineraryDao implements ItineraryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Itinerary getItineraryById(int id) {
        Itinerary itinerary = null;
        final String sql = "SELECT itinerary_id, title, city_id, user_id, date_of_travel, date_created\n" +
                "\tFROM itinerarys;";
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
    public Itinerary create(Itinerary itinerary) {
        Itinerary newItinerary = null;
        final String sql = "INSERT INTO itinerarys(title, city_id, user_id, date_of_travel, date_created)\n" +
                "VALUES (?, ?, ?, ?, ?);";
        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getTitle(),itinerary.getCityId(),
                    itinerary.getUserId(),itinerary.getDateOfTravel(),itinerary.getDateCreated());
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
                results.getDate("date_of_travel"),
                results.getDate("date_created")
        );
        return itinerary;
    }

}
