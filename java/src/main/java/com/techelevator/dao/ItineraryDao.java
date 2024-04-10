package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {

    public List<Itinerary> getAllItineraries(int userId);
}
