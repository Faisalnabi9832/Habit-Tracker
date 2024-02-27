package com.regexbyte.habittracker.Models;

public class StoryModel {
    private int storyImage;
    private String userName;
    private boolean isAddStory;
    private boolean viewed;
    public void setStoryImage(int storyImage) {
        this.storyImage = storyImage;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddStory(boolean addStory) {
        isAddStory = addStory;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public StoryModel(int storyImage, String userName, boolean isAddStory) {
        this.storyImage = storyImage;
        this.userName = userName;
        this.isAddStory = isAddStory;
        this.viewed = viewed;
    }

    public int getStoryImage() {
        return storyImage;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAddStory() {
        return isAddStory;
    }
}
