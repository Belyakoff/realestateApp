package com.apps.realestateapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApartmentsResponse {

    @SerializedName("apartments")
    @Expose
    private List<Apartment> apartments = null;


    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}
