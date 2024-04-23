package com.techelevator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.Future;
import java.time.LocalDate;

public class Itinerary {
    private int itineraryId;
    private String title;
    private int cityId;
    private int userId;
    @Future(message = "date must be in the future")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfTravel;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateCreated;
    private int[] landmarksArray;

    public Itinerary(int itineraryId, String title, int cityId, int userId, LocalDate dateOfTravel, LocalDate dateCreated) {
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

    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int[] getLandmarksArray() {
        return landmarksArray;
    }

    public void setLandmarksArray(int[] landmarksArray) {
        this.landmarksArray = landmarksArray;
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
