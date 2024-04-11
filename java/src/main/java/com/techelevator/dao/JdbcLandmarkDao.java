package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landit;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcLandmarkDao(DataSource dataSource, Landit landit) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcLandmarkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Landmark getLandmarkById(int landmarkId) {
        Landmark landmark = null;

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath\n" +
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
        List<Landmark> landmarkList = new ArrayList<>();

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath\n" +
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

    @Override
    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();

        String sql = "SELECT DISTINCT category\n" +
                "\tFROM landmarks;";
        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                String category = results.getString("category");
                categories.add(category);
            }
            System.out.println(categories);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return categories;
    }


    // Delete this Method once we find a better way to do this.
    @Override
    public Landit createLandmarkInItinerary(int landmarkId, int itineraryId) {
        Landit landit = new Landit();
        String sql = "INSERT INTO land_itin_helper(\n" +
                "\titinerary_id, landmark_id)\n" +
                "\tVALUES (?, ?) RETURNING;";

        try {
            Integer result = this.jdbcTemplate.queryForObject(sql, int.class, itineraryId, landmarkId);
            landit.setItineraryId(itineraryId);
            landit.setLandmarkId(landmarkId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return landit;
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
                results.getInt("dislike_count"),
                results.getString("imagePath"));
        return landmark;
    }
}
