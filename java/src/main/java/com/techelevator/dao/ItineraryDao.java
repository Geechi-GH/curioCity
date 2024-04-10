package com.techelevator.dao;

import com.techelevator.model.Itinerary;

public interface ItineraryDao {

    Itinerary getItineraryById (int id);
    Itinerary create (Itinerary itinerary);
}
