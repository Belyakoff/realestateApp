package com.apps.realestateapp.mocker;

import com.apps.realestateapp.model.Apartment;
import java.util.List;

import co.infinum.retromock.meta.Mock;
import co.infinum.retromock.meta.MockResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MockApartmentApi {

    @Mock
    @MockResponse(body = "[" + ApartmentMockItem.apartment0 + "," + ApartmentMockItem.apartment1 + "]")
    @GET("/")
    Call<List<Apartment>> getApartmentsList();

}
