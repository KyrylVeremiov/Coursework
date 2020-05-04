package com.example.coursework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {
    @SerializedName("location")
    @Expose
    private String location;

    public Search(){
        this.location="";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}