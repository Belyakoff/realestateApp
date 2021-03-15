package com.apps.realestateapp;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.apps.realestateapp.model.Apartment;
import com.apps.realestateapp.test.TestApartmentsRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UnitTestRepository {

    private MutableLiveData<List<Apartment>> mutableLiveData;
    private List<Apartment> apartmentArrayList;
    private Apartment apartment;

    @Before
    public void initLiveData(){
        if (mutableLiveData != null){
            return;
        }
        TestApartmentsRepository apartmentsRepository = TestApartmentsRepository.getInstance();
        mutableLiveData = apartmentsRepository.getApartments();
    }

    @Before
    public void CreateApartment(){
        apartment = new Apartment();

        apartment.setTitle("Квартира 1 комната");
        apartment.setHREF("abc");
        apartment.setRayon("Тушино");
        apartment.setAdress("Трикотажная");
        apartment.setPrice(50000);
        apartment.setSubprice("залог");
        apartment.setPhoneNumber("89001001010");
        apartment.setDescription("Сдам квартиру срочно");

        apartmentArrayList = new ArrayList<>();
    }


    public LiveData<List<Apartment>> getApartmentRepository() {
        return mutableLiveData;
    }

    Observer<List<Apartment>> apartmentsObserver = apartments -> apartmentArrayList.addAll(apartments);


    private static LifecycleOwner mockLifecycleOwner() {
        LifecycleOwner owner = mock(LifecycleOwner.class);
        LifecycleRegistry lifecycle = new LifecycleRegistry(owner);
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        when(owner.getLifecycle()).thenReturn(lifecycle);
        return owner;
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void data_isCorrect() {


        getApartmentRepository().observe(mockLifecycleOwner(), apartmentsObserver);

       System.out.println(apartmentArrayList);

        assertEquals(apartment, apartment); //placeholder
    }

}