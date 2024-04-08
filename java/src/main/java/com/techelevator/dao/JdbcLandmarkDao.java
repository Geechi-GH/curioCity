package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Landmark getLandmarkById(int landmarkId) {
        Landmark landmark = null;

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count\n" +
        "\tFROM landmarks \n" +
                "WHERE landmark_id = ?";

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

    @Override
    public List<Landmark> getAllLandmarks() {
        List <Landmark> landmarkList = new ArrayList<>();

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count\n" +
                "\tFROM landmarks;";
        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Landmark landmark = mapRowToLandmark(results);
                landmarkList.add(landmark);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return landmarkList;
    }

    public Landmark mapRowToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark(results.getInt("landmark_id"),
                results.getString("name"),
                results.getString("description"),
                results.getTime("weekday_open"),
                results.getTime("weekday_close"),
                results.getTime("weekend_open"),
                results.getTime("weekend_close"),
                results.getString("category"),
                results.getInt("city_id"),
                results.getInt("like_count"),
                results.getInt("dislike_count"));
        return landmark;
    }
}
