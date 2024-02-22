package com.regexbyte.habittracker.Models;

public class TimerModel {

    private String time;
    private String title;
    private int categoriesId;

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(String categoriesId) {

        this.categoriesId = Integer.parseInt(categoriesId);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
