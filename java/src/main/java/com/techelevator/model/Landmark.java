package com.techelevator.model;

import java.sql.Time;

public class Landmark {
    private int id;
    private String name;
    private String description;
    private Time weekdayOpen;
    private Time weekdayClose;
    private Time weekendOpen;
    private Time weekendClose;
    private String category;
    private int cityID;
    private int likeCount;
    private int dislikeCount;
    private String imagePath;
    private String website;

    public Landmark(int id, String name, String description, Time weekdayOpen, Time weekdayClose, Time weekendOpen, Time weekendClose,
                    String category, int cityID, int likeCount, int dislikeCount, String imagePath, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weekdayOpen = weekdayOpen;
        this.weekdayClose = weekdayClose;
        this.weekendOpen = weekendOpen;
        this.weekendClose = weekendClose;
        this.category = category;
        this.cityID = cityID;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.imagePath = imagePath;
        this.website = website;
    }

    public Landmark(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Time getWeekdayOpen() {
        return weekdayOpen;
    }

    public Time getWeekdayClose() {
        return weekdayClose;
    }

    public Time getWeekendOpen() {
        return weekendOpen;
    }

    public Time getWeekendClose() {
        return weekendClose;
    }

    public String getCategory() {
        return category;
    }

    public int getCityID() {
        return cityID;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getWebsite() {
        return website;
    }
}
