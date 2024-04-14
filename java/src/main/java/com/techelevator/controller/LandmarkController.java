package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class LandmarkController {
    final LandmarkDao landmarkDao;
    final UserDao userDao;

    public LandmarkController(LandmarkDao landmarkDao, UserDao userDao) {
        this.landmarkDao = landmarkDao;
        this.userDao = userDao;
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

    @PutMapping("/likes")
    public Landmark likeALandmark(@RequestBody Landmark landmark, Principal principal) {
        User user = this.userDao.getUserByUsername(principal.getName());
        try {
            return landmarkDao.likeALandmark(landmark, user.getId());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }

    @PutMapping("/dislikes")
    public Landmark dislikeALandmark(@RequestBody Landmark landmark, Principal principal) {
        User user = this.userDao.getUserByUsername(principal.getName());
        try {
            return landmarkDao.dislikeALandmark(landmark, user.getId());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }
}
