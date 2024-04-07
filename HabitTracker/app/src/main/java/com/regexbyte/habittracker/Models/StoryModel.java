package com.regexbyte.habittracker.Models;

import android.net.Uri;

public class StoryModel {
    private int storyImage;
    private String userName;
    private boolean isAddStory;
    private boolean viewed;
    private Uri storyImageUri;

    private int userId;


    public StoryModel(int storyImage, String userName, boolean isAddStory ,int userId ) {
        this.storyImage = storyImage;
        this.userName = userName;
        this.isAddStory = isAddStory;
        this.viewed = viewed;
        this.userId=userId;
    }

    public Uri getStoryImageUri() {
        return storyImageUri;
    }

    public void setStoryImageUri(Uri storyImageUri) {
        this.storyImageUri = storyImageUri;
    }

    public void setStoryImage(int storyImage) {
        this.storyImage = storyImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
