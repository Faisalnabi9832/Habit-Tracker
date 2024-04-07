// PostModel.java
package com.regexbyte.habittracker.Models;

import android.net.Uri;

import com.regexbyte.habittracker.R;

import java.util.ArrayList;
import java.util.List;

public class PostModel {
    private String username;
    private String postedTime;
    private int userProfileImage;
    private int postedImage;
    private boolean isLiked;
    private List<Comment> comments;

    private List<Uri> imageUris;
    private boolean likeButtonVisible;


    public PostModel(String username, String postedTime, int userProfileImage, int postedImage, boolean isLiked,List<Uri> imageUris) {
        this.username = username;
        this.postedTime = postedTime;
        this.userProfileImage = userProfileImage;
        this.postedImage = postedImage;
        this.isLiked = isLiked;
        this.comments = new ArrayList<>();
        this.likeButtonVisible = false;

        this.imageUris=imageUris;

    }

    public List<Uri> getImageUris() {
        return imageUris;
    }

    public void setImageUris(List<Uri> imageUris) {
        this.imageUris = imageUris;
    }

    public boolean isLiked() {
        return isLiked;
    }
    public boolean isLikeButtonVisible() {
        return likeButtonVisible;
    }

    public void toggleLikeButtonVisibility() {
        likeButtonVisible = !likeButtonVisible;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }



    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment newComment) {
        comments.add(newComment);
    }


    public String getUsername() {
        return username;
    }

    public String getPostedTime() {
        return postedTime;
    }

    public int getUserProfileImage() {
        return userProfileImage;
    }

    public void setPostedImage(int postedImage) {
        this.postedImage = postedImage;
    }

    public int getPostedImage() {
        return postedImage;
    }

    public boolean hasComments() {
        return comments != null && !comments.isEmpty();
    }





    private List<Integer> generateDummyViewers() {
        List<Integer> dummyViewers = new ArrayList<>();
        // Add dummy viewer profile images
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);
        dummyViewers.add(R.drawable.profilepic);

        // Add more dummy viewers as needed
        return dummyViewers;
    }
}
