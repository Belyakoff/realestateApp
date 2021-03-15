package com.apps.realestateapp.test;

import androidx.lifecycle.MutableLiveData;
import com.apps.realestateapp.mocker.MockerService;
import com.apps.realestateapp.mocker.MockApartmentApi;
import com.apps.realestateapp.model.Apartment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class TestApartmentsRepository {

    private static TestApartmentsRepository apartmentsRepository;

    public static TestApartmentsRepository getInstance() {
        if (apartmentsRepository == null){
            apartmentsRepository = new TestApartmentsRepository();
        }
        return apartmentsRepository;
    }

    //private ApartmentApi apartmentApi;
    private MockApartmentApi mockApartmentApi;
    private MockerService mocker;

    public TestApartmentsRepository() {
        //apartmentApi = RetrofitService.createService(ApartmentApi.class);
        mocker  = new MockerService();
        mockApartmentApi = mocker.createService();
    }

    public MutableLiveData<List<Apartment>> getApartments(){
        MutableLiveData<List<Apartment>> apartmentsData = new MutableLiveData<>();
        System.out.println("DEBUG getApartments() is being executed");


        mockApartmentApi.getApartmentsList().enqueue(new Callback<List<Apartment>>() {

            @Override
            public void onResponse(Call<List<Apartment>> call, Response<List<Apartment>> response) {
                if (response.isSuccessful()){

                    apartmentsData.setValue(response.body());

                    System.out.println("DEBUG onResponse is being executed");
                    // System.out.println(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Apartment>> call, Throwable t) {
                t.printStackTrace();
                System.out.println("DEBUG onFailure is being executed");
                apartmentsData.setValue(null);
            }
        });

        return apartmentsData;
    }

}
