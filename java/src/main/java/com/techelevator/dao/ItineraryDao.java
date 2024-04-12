package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.User;

import java.util.List;

public interface ItineraryDao {

    public List<Itinerary> getAllItineraries(int userId);

    Itinerary getItineraryById(int id, int userId);

    Itinerary create(Itinerary itinerary, User user);

    Itinerary addingLandmarkToItinerary(int userId, Itinerary itinerary);
}
