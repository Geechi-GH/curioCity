package com.techelevator.dao;

import com.techelevator.model.LandRatDTO;
import com.techelevator.model.Landmark;

import java.util.List;
import java.util.Set;

public interface LandmarkDao {
    List<Landmark> getAllLandmarks();

    LandRatDTO getLandmarkById(int landmarkId, int userId);

    Set<String> getAllCategories();

    LandRatDTO likeALandmark(Landmark landmark, int userId);

    LandRatDTO dislikeALandmark(Landmark landmark, int userId);
}
