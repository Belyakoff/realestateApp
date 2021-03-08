package com.apps.realestateapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.apps.realestateapp.ui.adapters.ApartmentListAdapter;
import com.apps.realestateapp.model.Apartment;
import com.apps.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;


public class HomeFragment extends Fragment {

    private ArrayList<Apartment> apartmentArrayList = new ArrayList<>();
    private ApartmentListAdapter apartmentListAdapter;
    private HomeViewModel homeViewModel;
    RecyclerView rvHeadline;
    Apartment item = new Apartment();



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        item.setTitle("abc");
        item.setHREF("Lorem ipsum");
        apartmentArrayList.add(item);
        apartmentArrayList.add(item);



        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHeadline = view.findViewById(R.id.apartmentsList);

        setupRecyclerView();

        return view;
    }

    private void setupRecyclerView(){
        if (apartmentListAdapter == null) {

            apartmentListAdapter = new ApartmentListAdapter(getContext(), apartmentArrayList);

            rvHeadline.setLayoutManager(new LinearLayoutManager(getContext()));
            rvHeadline.setAdapter(apartmentListAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            apartmentListAdapter.notifyDataSetChanged();
        }
    }
}