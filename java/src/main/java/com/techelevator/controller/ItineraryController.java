package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
@RestController
@CrossOrigin
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
}

