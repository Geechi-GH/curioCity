package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao{

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

            while(results.next()) {
                Itinerary itinerary = myMapper(results);
                myList.add(itinerary);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server/database", e);
        }
        return myList;
    }

    private Itinerary myMapper(SqlRowSet result) {
        Itinerary itinerary = new Itinerary(
                result.getInt("itinerary_id"),
                result.getString("title"),
                result.getInt("city_id"),
                result.getInt("user_id"),
                result.getDate("date_of_travel"),
                result.getDate("date_created")
        );
        return itinerary;
    }
}
