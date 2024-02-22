package com.regexbyte.habittracker.Models;

import com.google.gson.annotations.SerializedName;

public class Modeforlogin {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public Modeforlogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
