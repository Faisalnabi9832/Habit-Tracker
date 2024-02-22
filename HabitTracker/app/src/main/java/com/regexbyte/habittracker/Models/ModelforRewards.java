package com.regexbyte.habittracker.Models;

public class ModelforRewards {
    private String count;
    private String description;
    private String title;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelforRewards(String count, String description, String title) {
        this.count = count;
        this.description = description;
        this.title = title;
    }
}
