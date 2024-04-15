package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.Review;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Review> getAllReviews(int landmarkId) {
        List<Review> myList = new ArrayList<>();
        String sql = "SELECT user_id, landmark_id, title, review, name\n" +
                "\tFROM reviews\n" +
                "\tWHERE landmark_id = ?;";

        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, landmarkId);
            while(results.next()) {
                Review review = mapRow(results);
                myList.add(review);
            }
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return myList;
    }

    public Review mapRow(SqlRowSet rs) {

        Review review = new Review();
        review.setUserId(rs.getInt("user_id"));
        review.setLandmarkId(rs.getInt("landmark_id"));
        review.setTitle(rs.getString("title"));
        review.setReview(rs.getString("review"));
        review.setName(rs.getString("name"));

        return review;
    }
}
