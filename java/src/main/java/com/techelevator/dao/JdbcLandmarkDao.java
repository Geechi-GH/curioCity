package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.LandRatDTO;
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
    private final String SELECT_JOIN_RATINGS_SQL = "SELECT l.landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagepath, website, like_status\n" +
            "\tFROM landmarks AS l\n" +
            "\tLEFT OUTER JOIN ratings AS r ON l.landmark_id = r.landmark_id AND r.user_id = ? \n" +
            "\tWHERE l.landmark_id = ?;";

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public LandRatDTO getLandmarkById(int landmarkId, int userId) {
        LandRatDTO landRatDTO = null;

        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(SELECT_JOIN_RATINGS_SQL, userId, landmarkId);
            if (results.next()) {
                landRatDTO = mapRowToLandRat(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return landRatDTO;
    }

    @Override
    public List<Landmark> getAllLandmarks() {
        List<Landmark> landmarkList = new ArrayList<>();

        final String sql = "SELECT landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath, website \n" +
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

    private final String INSERT_RATING_SQL = "INSERT INTO ratings (user_id, landmark_id, like_status)\n" +
            "\tVALUES( ?, ?, ?)\n" +
            "\tRETURNING landmark_id;";
    private final String UPDATE_LANDMARK_SQL = "UPDATE landmarks\n" +
            "\tSET like_count = like_count + ?, dislike_count = dislike_count + ?\n" +
            "\tWHERE landmark_id = ? ;";
    private final String UPDATE_RATING_SQL = "UPDATE ratings\n" +
            "\tSET like_status = ? \n" +
            "\tWHERE user_id = ? AND landmark_id = ? \n" +
            "\tRETURNING landmark_id;";
    private final String DELETE_RATING_SQL = "DELETE FROM ratings\n" +
            "\tWHERE landmark_id = ? AND user_id = ?\n" +
            "RETURNING landmark_id;";
    private final int DISLIKED = -1;
    private final int LIKED = 1;
    private final int NO_ENTRY = 0;

    @Override
    public LandRatDTO likeALandmark(Landmark landmark, int userId) {
        int landmarkId = landmark.getId();
        int veryUniqueLandmarkId = 0;
        LandRatDTO landRatDTO = null;

        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(SELECT_JOIN_RATINGS_SQL, userId, landmarkId);
            if (results.next()) {
                landRatDTO = mapRowToLandRat(results);
            }
            int likeStatus = landRatDTO.getLikeStatus();
            // if it is disliked
            if (likeStatus == DISLIKED) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(UPDATE_RATING_SQL, int.class, LIKED, userId, landmarkId);
                int moreRowsTouched = jdbcTemplate.update(UPDATE_LANDMARK_SQL, CLICKED, UNCLICKED, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly update the ratings or landmarks when the rating existed");
                }
                LandRatDTO tempLandRat = getLandmarkById(veryUniqueLandmarkId, userId);
                return landmarkToLandRat(tempLandRat.getLandmark(), LIKED);
            } else
                // if it is already liked
                if (likeStatus == LIKED) {
                    veryUniqueLandmarkId = jdbcTemplate.queryForObject(DELETE_RATING_SQL, int.class, landmarkId, userId);
                    int moreRowsTouched = jdbcTemplate.update(UPDATE_LANDMARK_SQL, UNCLICKED, NO_CLICK, landmarkId);
                    if (moreRowsTouched < 1) {
                        throw new DaoException("Did not properly remove the like");
                    }
                    LandRatDTO tempLandRat = getLandmarkById(veryUniqueLandmarkId, userId);
                    return landmarkToLandRat(tempLandRat.getLandmark(), NO_ENTRY);
                } else
                    // if there is no like entry
                    if (likeStatus == NO_ENTRY) {
                        int newLandmarkId = this.jdbcTemplate.queryForObject(INSERT_RATING_SQL, int.class, userId, landmarkId, LIKED);
                        int rowsAffected = this.jdbcTemplate.update(UPDATE_LANDMARK_SQL, CLICKED, NO_CLICK, newLandmarkId);
                        if (rowsAffected < 1) {
                            throw new DaoException("cannot update rating");
                        }
                        LandRatDTO tempLandRat = getLandmarkById(newLandmarkId, userId);
                        return landmarkToLandRat(tempLandRat.getLandmark(), LIKED);
                    } else {
                        throw new DaoException("Something broke");
                    }
        } catch (EmptyResultDataAccessException e) {
            throw new DaoException("Couldnt access the data");
        }
    }

    @Override
    public LandRatDTO dislikeALandmark(Landmark landmark, int userId) {
        int landmarkId = landmark.getId();
        int veryUniqueLandmarkId = 0;
        LandRatDTO landRatDTO = null;
        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(SELECT_JOIN_RATINGS_SQL, userId, landmarkId);
            if (results.next()) {
                landRatDTO = mapRowToLandRat(results);
            }
            int likeStatus = landRatDTO.getLikeStatus();
            if (likeStatus == LIKED) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(UPDATE_RATING_SQL, int.class, DISLIKED, userId, landmarkId);
                int moreRowsTouched = jdbcTemplate.update(UPDATE_LANDMARK_SQL, UNCLICKED, CLICKED, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly update the ratings or landmarks when the rating existed");
                }
                LandRatDTO tempLandRat = getLandmarkById(veryUniqueLandmarkId, userId);
                return landmarkToLandRat(tempLandRat.getLandmark(), DISLIKED);
            } else if (likeStatus == DISLIKED) {
                veryUniqueLandmarkId = jdbcTemplate.queryForObject(DELETE_RATING_SQL, int.class, landmarkId, userId);
                int moreRowsTouched = jdbcTemplate.update(UPDATE_LANDMARK_SQL, NO_CLICK, UNCLICKED, landmarkId);
                if (moreRowsTouched < 1) {
                    throw new DaoException("Did not properly remove the like");
                }
                LandRatDTO tempLandRat = getLandmarkById(veryUniqueLandmarkId, userId);
                return landmarkToLandRat(tempLandRat.getLandmark(), NO_ENTRY);
            } else if (likeStatus == NO_ENTRY) {
                int newLandmarkId = this.jdbcTemplate.queryForObject(INSERT_RATING_SQL, int.class, userId, landmarkId, DISLIKED);
                int rowsAffected = this.jdbcTemplate.update(UPDATE_LANDMARK_SQL, NO_CLICK, CLICKED, newLandmarkId);
                if (rowsAffected < 1) {
                    throw new DaoException("cannot update rating");
                }
                LandRatDTO tempLandRat = getLandmarkById(newLandmarkId, userId);
                return landmarkToLandRat(tempLandRat.getLandmark(), DISLIKED);
            } else {
                throw new DaoException("something went terribly wrong, restart computer");
            }
        } catch (EmptyResultDataAccessException e) {
            throw new DaoException("Something went wrong");
        }
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
                results.getString("website"));
        return landmark;
    }

    public LandRatDTO mapRowToLandRat(SqlRowSet results) {
        LandRatDTO landRat = new LandRatDTO();
        Landmark landmark = new Landmark(
                results.getInt("landmark_id"),
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
                results.getString("website")
        );
        int likeStatus = results.getInt("like_status");
        landRat.setLandmark(landmark);
        landRat.setLikeStatus(likeStatus);
        return landRat;
    }

    public LandRatDTO landmarkToLandRat(Landmark landmark, int likeStatus) {
        LandRatDTO landRatDTO = new LandRatDTO();
        landRatDTO.setLandmark(landmark);
        landRatDTO.setLikeStatus(likeStatus);
        return landRatDTO;
    }
}
