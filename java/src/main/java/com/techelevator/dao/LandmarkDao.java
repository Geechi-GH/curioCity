package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;
import java.util.Set;

public interface LandmarkDao {
    Landmark getLandmarkById(int landmarkId);

    List<Landmark> getAllLandmarks();

    Set<String> getAllCategories();


}
