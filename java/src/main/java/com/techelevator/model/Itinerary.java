package com.techelevator.model;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

public class Itinerary {
    private int itineraryId;
    private String title;
    private int cityId;
    private int userId;
    @Future(message = "date must be in the future")
    private Date dateOfTravel;
    private Date dateCreated;

    public Itinerary(int itineraryId, String title, int cityId, int userId, Date dateOfTravel, Date dateCreated) {
        this.itineraryId = itineraryId;
        this.title = title;
        this.cityId = cityId;
        this.userId = userId;
        this.dateOfTravel = dateOfTravel;
        this.dateCreated = dateCreated;
    }



    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "itineraryId=" + itineraryId +
                ", title='" + title + '\'' +
                ", cityId=" + cityId +
                ", userId=" + userId +
                ", dateOfTravel=" + dateOfTravel +
                ", dateCreated=" + dateCreated +
                '}';
    }
}

