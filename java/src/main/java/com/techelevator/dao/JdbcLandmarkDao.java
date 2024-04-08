package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Landmark getLandmark(int landmarkId) {
        Landmark landmark = null;

        final String sql = "SELECT id, name, description, weekdayOpen, weekdayClose, weekendOpen, weekendClose, category, " +
                " cityID, likeCount, dislikeCount" +
                "FROM landmarks" +
                "WHERE landmarkId = ?";

        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
            if (results.next()) {
                landmark = mapRowToLandmark(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return landmark;
    }

    public Landmark mapRowToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark(results.getInt("id"),
                results.getString("name"),
                results.getString("description"),
                results.getString("weekdayOpen"),
                results.getString("weekdayClose"),
                results.getString("weekendOpen"),
                results.getString("weekendClose"),
                results.getString("category"),
                results.getInt("cityId"),
                results.getInt("likeCount"),
                results.getInt("dislikeCount"));
        return landmark;
    }
}
