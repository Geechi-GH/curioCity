package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;
import java.util.Set;

public interface LandmarkDao {

    List<Landmark> getAllLandmarks();

    Landmark getLandmarkById(int landmarkId);

    Set<String> getAllCategories();

    Landmark likeALandmark(Landmark landmark, int userId);
    Landmark dislikeALandmark(Landmark landmark, int userId);
}
