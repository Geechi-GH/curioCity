package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDao {
    Landmark getLandmarkById(int landmarkId);

    List<Landmark> getAllLandmarks();

}
