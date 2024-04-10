package com.techelevator.model;

public class Landit {
    private int landmarkId;
    private int itineraryId;

    public Landit(int landmarkId, int itineraryId) {
        this.landmarkId = landmarkId;
        this.itineraryId = itineraryId;
    }

    public Landit() {

    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }
}

