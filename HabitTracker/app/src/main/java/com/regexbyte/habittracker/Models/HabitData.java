package com.regexbyte.habittracker.Models;

public class HabitData {
    private String habbit_name;
    private String habbit_end_date;
    private String count;
    private String habbit_time_one;
    private String hb_sunday;
    private String hb_monday;
    private String hb_tuesday;
    private String hb_wednesday;
    private String hb_thursday;
    private String hb_friday;
    private String hb_saturday;
    private int imageUrl;

    public HabitData(String habbit_name, String habbit_end_date, String count, String habbit_time_one,
                     String hb_sunday, String hb_monday, String hb_tuesday, String hb_wednesday,
                     String hb_thursday, String hb_friday, String hb_saturday, int imageUrl) {
        this.habbit_name = habbit_name;
        this.habbit_end_date = habbit_end_date;
        this.count = count;
        this.habbit_time_one = habbit_time_one;
        this.hb_sunday = hb_sunday;
        this.hb_monday = hb_monday;
        this.hb_tuesday = hb_tuesday;
        this.hb_wednesday = hb_wednesday;
        this.hb_thursday = hb_thursday;
        this.hb_friday = hb_friday;
        this.hb_saturday = hb_saturday;
        this.imageUrl = imageUrl;
    }

    // Add getters for all properties

    public String getHabbit_name() {
        return habbit_name;
    }

    public void setHabbit_end_date(String habbit_end_date) {
        this.habbit_end_date = habbit_end_date;
    }

    public String getHabbit_end_date() {
        return habbit_end_date;
    }

    public String getCount() {
        return count;
    }

    public String getHabbit_time_one() {
        return habbit_time_one;
    }

    public String getHb_sunday() {
        return hb_sunday;
    }

    public String getHb_monday() {
        return hb_monday;
    }

    public String getHb_tuesday() {
        return hb_tuesday;
    }

    public String getHb_wednesday() {
        return hb_wednesday;
    }

    public String getHb_thursday() {
        return hb_thursday;
    }

    public String getHb_friday() {
        return hb_friday;
    }

    public String getHb_saturday() {
        return hb_saturday;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
