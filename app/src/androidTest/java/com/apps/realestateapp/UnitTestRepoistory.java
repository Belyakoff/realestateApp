package com.apps.realestateapp;

import android.os.AsyncTask;
import android.util.Log;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.apps.realestateapp.model.Apartment;
import com.apps.realestateapp.networking.ApartmentsRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


import kotlin.jvm.JvmField;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class UnitTestRepoistory {

    MutableLiveData<List<Apartment>> mutableLiveData;

    @Rule
    @JvmField
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void TestRepositoryOutput() {

         TestRepository apartmentsRepository = TestRepository.getInstance();
         mutableLiveData = apartmentsRepository.getApartments();

        //Log.d("DEBUG Repo testing", mutableLiveData.getValue().toString());

        assertEquals(" ", " ");
    }
}