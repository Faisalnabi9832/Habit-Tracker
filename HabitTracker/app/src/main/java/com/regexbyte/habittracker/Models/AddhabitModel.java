package com.regexbyte.habittracker.Models;

public class AddhabitModel {

    private int imageResource;
    private String text;
    private int categoryId;

    public AddhabitModel(int imageResource, String text, int categoryId) {
        this.imageResource = imageResource;
        this.text = text;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
