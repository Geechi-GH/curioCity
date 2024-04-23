package com.techelevator.model;

public class Review {
    private int userId;
    private int landmarkId;
    private String review;
    private String title;
    private String name;

    public Review(int userId, int landmarkId, String review, String title, String name) {
        this.userId = userId;
        this.landmarkId = landmarkId;
        this.review = review;
        this.title = title;
        this.name = name;
    }

    public Review() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
