package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.User;

import java.util.List;

public interface ItineraryDao {
    List<Itinerary> getAllItineraries(int userId);

    Itinerary getItineraryById(int id, int userId);

    Itinerary create(Itinerary itinerary, User user);

    Itinerary flushAndFill(int[] landmarkArray, Itinerary itinerary);

    Itinerary editItinerary(Itinerary itinerary);
}
