package com.regexbyte.habittracker.Models;

public class Comment {
    private int userProfileImage;
    private String username;
    private String comment;

    public Comment(int userProfileImage, String username, String comment) {
        this.userProfileImage = userProfileImage;
        this.username = username;
        this.comment = comment;
    }

    public int getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(int userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
