package com.apps.realestateapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Apartment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("rayon")
    @Expose
    private String rayon;
    @SerializedName("adress")
    @Expose
    private String adress;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("subprice")
    @Expose
    private String subprice;
    @SerializedName("phone_number")
    @Expose
    private String phone_number;
    @SerializedName("description")
    @Expose
    private String description;

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

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

    public String getRayon() {
        return rayon;
    }
    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubprice() {
        return subprice;
    }
    public void setSubprice(String subprice) {
        this.subprice = subprice;
    }

    public String getPhoneNumber() {
        return phone_number;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}

