package com.techelevator.model;

public class Landmark {
    private int id;
    private String name;
    private String description;
    private String weekdayOpen;
    private String weekdayClose;
    private String weekendOpen;
    private String weekendClose;
    private String category;
    private String imageUrl;
    private int cityID;
    private int likeCount;
    private int dislikeCount;

    public Landmark(int id, String name, String description, String weekdayOpen, String weekdayClose, String weekendOpen, String weekendClose,
                    String category, String imageUrl, int cityID, int likeCount, int dislikeCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weekdayOpen = weekdayOpen;
        this.weekdayClose = weekdayClose;
        this.weekendOpen = weekendOpen;
        this.weekendClose = weekendClose;
        this.category = category;
        this.imageUrl = imageUrl;
        this.cityID = cityID;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
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

    public String getWeekdayOpen() {
        return weekdayOpen;
    }

    public String getWeekdayClose() {
        return weekdayClose;
    }

    public String getWeekendOpen() {
        return weekendOpen;
    }

    public String getWeekendClose() {
        return weekendClose;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
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
}
