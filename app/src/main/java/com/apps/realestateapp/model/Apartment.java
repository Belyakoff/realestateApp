package com.apps.realestateapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Apartment {


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("href")
    @Expose
    private String href;



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getHREF() {
        return href;
    }
    public void setHREF(String href) {
        this.href = href;
    }



}

