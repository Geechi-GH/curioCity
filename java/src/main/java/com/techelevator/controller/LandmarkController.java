package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class LandmarkController {
    final LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping("/landmarks")
    public List<Landmark> getAllLandmarks() {
        try {
            return landmarkDao.getAllLandmarks();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }

    @GetMapping("/landmarks/{id}")
    public Landmark getLandmarkId(@PathVariable int id) {
        try {
            return landmarkDao.getLandmarkById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }

    @GetMapping("/categories")
    public Set<String> getAllCategories() {
        try {
            return landmarkDao.getAllCategories();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }
}
