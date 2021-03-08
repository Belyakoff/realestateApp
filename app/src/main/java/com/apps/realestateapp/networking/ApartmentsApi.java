package com.apps.realestateapp.networking;

import com.apps.realestateapp.model.Apartment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApartmentsApi {
    @GET("apartments")
    Call<List<Apartment>> getApartmentsList();
}

