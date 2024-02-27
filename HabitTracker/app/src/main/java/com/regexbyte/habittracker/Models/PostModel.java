// PostModel.java
package com.regexbyte.habittracker.Models;

import com.regexbyte.habittracker.R;

import java.util.ArrayList;
import java.util.List;

public class PostModel {
    private String username;
    private String postedTime;
    private int userProfileImage;
    private int postedImage;
    private boolean isLiked;
    private List<String> comments;
    private List<Integer> allUserImages;

    public PostModel(String username, String postedTime, int userProfileImage, int postedImage, boolean isLiked) {
        this.username = username;
        this.postedTime = postedTime;
        this.userProfileImage = userProfileImage;
        this.postedImage = postedImage;
        this.isLiked = isLiked;
        this.comments = new ArrayList<>();
        this.allUserImages = generateDummyViewers(); // Initialize dummy viewers
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
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

    public List<Integer> getAllUserImages() {
        return allUserImages;
    }

    public void addAllUserImage(int userImage) {
        allUserImages.add(userImage);
    }

    public List<Integer> getFirstFourUserImages() {
        if (allUserImages.size() > 4) {
            return allUserImages.subList(0, 4);
        } else {
            return allUserImages;
        }
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
