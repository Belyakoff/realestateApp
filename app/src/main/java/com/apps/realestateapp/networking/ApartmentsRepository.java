package com.apps.realestateapp.networking;

import androidx.lifecycle.MutableLiveData;
import com.apps.realestateapp.model.Apartment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import java.util.List;

public class ApartmentsRepository {

    private static ApartmentsRepository apartmentsRepository;

    public static ApartmentsRepository getInstance(){
        if (apartmentsRepository == null){
            apartmentsRepository = new ApartmentsRepository();
        }
        return apartmentsRepository;
    }

    private ApartmentsApi apartmentsApi;

    public ApartmentsRepository(){
        apartmentsApi = RetrofitService.createService(ApartmentsApi.class);
    }

    public MutableLiveData<List<Apartment>> getApartments(){
        MutableLiveData<List<Apartment>> apartmentsData = new MutableLiveData<>();


            apartmentsApi.getApartmentsList().enqueue(new Callback<List<Apartment>>() {

            @Override
            public void onResponse(Call<List<Apartment>> call,
                                   Response<List<Apartment>> response) {
                if (response.isSuccessful()){
                    Log.d("DEBUG onresponse","ok");
                    apartmentsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Apartment>> call, Throwable t) {
                t.printStackTrace();

                apartmentsData.setValue(null);
            }
        });

        return apartmentsData;
    }

}
