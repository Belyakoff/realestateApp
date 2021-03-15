package com.apps.realestateapp.mocker;

import co.infinum.retromock.Retromock;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MockerService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Retromock retromock = new Retromock.Builder()
            .retrofit(retrofit)
            .build();

    public MockApartmentApi createService() {
        MockApartmentApi service = retromock.create(MockApartmentApi.class);

        return service;
    }

}
