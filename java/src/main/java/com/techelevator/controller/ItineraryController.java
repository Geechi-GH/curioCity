package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@CrossOrigin
public class ItineraryController {
    final ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    @GetMapping("/itineraries")
    public List<Itinerary> getAllMyItineraries() {
        return null;
    }

    @GetMapping("/itineraries/{id}")
    public Itinerary getItineraryById(@PathVariable int id) {
        try {
            return itineraryDao.getItineraryById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to server");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/itineraries")
    public Itinerary create(@RequestBody Itinerary itinerary) {
        try {
            return itineraryDao.create(itinerary);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Something went wrong");
        }
    }
}

