package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private final int CLICKED = 1;
    private final int UNCLICKED = -1;
    private final int NO_CLICK = 0;

    private final int RED = -1;
    private final int GREEN = 1;
    private final int WHITE = 0;
    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Landmark getLandmarkById(int landmarkId) {
        Landmark landmark = null;

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath, website, vote_rep \n" +
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


        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath, website, vote_rep \n" +
                "\tFROM landmarks " +
                "ORDER BY landmark_id ASC;";

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

    @Override
    public Landmark likeALandmark(Landmark landmark, int userId) {
        int landmarkId = landmark.getId();
        int veryUniqueLandmarkId = 0;

        String sqlSelect = "SELECT isLiked\n" +
                "FROM ratings\n" +
                "WHERE user_id = ? AND landmark_id = ? ;\n";

        String sqlInsert = "INSERT INTO ratings(user_id, landmark_id, isLiked)\n" +
                "VALUES(?,?,true)" +
                "RETURNING landmark_id;";

        String sqlUpdateLandmarks = "\n" +
                "UPDATE landmarks\n" +
                "SET like_count = like_count + ?, dislike_count = dislike_count + ?, vote_rep = ? \n" +
                "WHERE landmark_id = ? ;";

        String sqlUpdateRatings = "UPDATE ratings\n" +
                "SET isLiked = true\n" +
                "WHERE user_id = ? AND landmark_id = ? " +
                "RETURNING landmark_id;";

        String sqlDeleteRating = "DELETE FROM ratings\n" +
                "\tWHERE landmark_id = ? AND user_id = ?" +
                "RETURNING landmark_id;";
        try {
            boolean result = this.jdbcTemplate.queryForObject(sqlSelect, boolean.class, userId, landmarkId);
            // if we selected a rating that is there and the rating is false (disliked)
            if (!result) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(sqlUpdateRatings, int.class, userId, landmarkId);
                int moreRowsTouched = jdbcTemplate.update(sqlUpdateLandmarks, CLICKED, UNCLICKED, GREEN, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly update the ratings or landmarks when the rating existed");
                }
            }
            if (result) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(sqlDeleteRating, int.class, landmarkId, userId);
                int moreRowsTouched = jdbcTemplate.update(sqlUpdateLandmarks, UNCLICKED, NO_CLICK, WHITE, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly remove the like");
                }
            }
        } catch (EmptyResultDataAccessException e) {
            // if there is no
            int newLandmarkId = this.jdbcTemplate.queryForObject(sqlInsert, int.class, userId, landmarkId);
            int rowsAffected = this.jdbcTemplate.update(sqlUpdateLandmarks, CLICKED, NO_CLICK, GREEN, newLandmarkId);
            if (rowsAffected < 1) {
                throw new DaoException("cannot update rating");
            }
            return getLandmarkById(newLandmarkId);
        }
        return getLandmarkById(veryUniqueLandmarkId);
    }

    @Override
    public Landmark dislikeALandmark(Landmark landmark, int userId) {
        int landmarkId = landmark.getId();
        int veryUniqueLandmarkId = 0;

        String sqlSelect = "SELECT isLiked\n" +
                "FROM ratings\n" +
                "WHERE user_id = ? AND landmark_id = ? ;\n";

        String sqlInsert = "INSERT INTO ratings(user_id, landmark_id, isLiked)\n" +
                "VALUES(?,?,false)" +
                "RETURNING landmark_id;";

        String sqlUpdateLandmarks = "\n" +
                "UPDATE landmarks\n" +
                "SET like_count = like_count + ?, dislike_count = dislike_count + ?, vote_rep = ? \n" +
                "WHERE landmark_id = ? ;";

        String sqlUpdateRatings = "UPDATE ratings\n" +
                "SET isLiked = false\n" +
                "WHERE user_id = ? AND landmark_id = ? " +
                "RETURNING landmark_id;";

        String sqlDeleteRating = "DELETE FROM ratings\n" +
                "\tWHERE landmark_id = ? AND user_id = ?" +
                "RETURNING landmark_id;";
        try {
            boolean result = this.jdbcTemplate.queryForObject(sqlSelect, boolean.class, userId, landmarkId);
            // if we selected a rating that is there and the rating is false (disliked)
            if (result) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(sqlUpdateRatings, int.class, userId, landmarkId);
                int moreRowsTouched = jdbcTemplate.update(sqlUpdateLandmarks, UNCLICKED, CLICKED, RED, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly update the ratings or landmarks when the rating existed");
                }
            }
            if (!result) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(sqlDeleteRating, int.class, landmarkId, userId);
                int moreRowsTouched = jdbcTemplate.update(sqlUpdateLandmarks, NO_CLICK, UNCLICKED, WHITE, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly remove the like");
                }
            }
        } catch (EmptyResultDataAccessException e) {
            int newLandmarkId = this.jdbcTemplate.queryForObject(sqlInsert, int.class, userId, landmarkId);
            int rowsAffected = this.jdbcTemplate.update(sqlUpdateLandmarks, NO_CLICK, CLICKED, RED, newLandmarkId);
            if (rowsAffected < 1) {
                throw new DaoException("cannot update rating");
            }
            return getLandmarkById(newLandmarkId);
        }
        return getLandmarkById(veryUniqueLandmarkId);
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
                results.getString("imagePath"),
                results.getString("website"),
                results.getInt("vote_rep"));
        return landmark;
    }
}
