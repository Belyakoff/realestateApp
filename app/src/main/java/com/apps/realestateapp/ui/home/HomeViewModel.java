package com.apps.realestateapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apps.realestateapp.model.Apartment;
import com.apps.realestateapp.networking.ApartmentsRepository;

import android.util.Log;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Apartment>> mutableLiveData;
    private ApartmentsRepository apartmentsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        apartmentsRepository = ApartmentsRepository.getInstance();
        mutableLiveData = apartmentsRepository.getApartments();
    }

    public LiveData<List<Apartment>> getApartmentRepository() {
        return mutableLiveData;
    }
}