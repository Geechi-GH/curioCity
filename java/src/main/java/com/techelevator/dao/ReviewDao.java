package com.techelevator.dao;


import com.techelevator.model.Landmark;
import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> getAllReviews(int landmarkId);
}
