package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ItineraryController {
    private ItineraryDao itineraryDao;
    private UserDao userDao;

    public ItineraryController(ItineraryDao itineraryDao, UserDao userDao) {
        this.itineraryDao = itineraryDao;
        this.userDao = userDao;
    }

    @GetMapping("/itineraries")
    public List<Itinerary> getAllMyItineraries(Principal principal) {
        User user = this.userDao.getUserByUsername(principal.getName());
        return this.itineraryDao.getAllItineraries(user.getId());
    }

    @GetMapping("/itineraries/{id}")
    public Itinerary getItineraryById(@PathVariable int id,  Principal principal) {
        User user = this.userDao.getUserByUsername(principal.getName());
        try {
            return itineraryDao.getItineraryById(id, user.getId());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/itineraries")
    public Itinerary create(@RequestBody Itinerary itinerary, Principal principal) {
        String username = principal.getName();
        final User user = this.userDao.getUserByUsername(username);
        try {
            return itineraryDao.create(itinerary, user);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Something went wrong");
        }
    }

    @PostMapping("/itinerary/{id}")
    public Itinerary addingLandmarkToItinerary(@RequestBody Itinerary itinerary, Principal principal) {
        User user = this.userDao.getUserByUsername(principal.getName());
        try {
            return itineraryDao.addingLandmarkToItinerary(user.getId(), itinerary);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Something went wrong");
        }
    }
}
