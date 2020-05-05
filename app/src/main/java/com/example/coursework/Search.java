package com.example.coursework;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Search {
    @PrimaryKey
    public long id;
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