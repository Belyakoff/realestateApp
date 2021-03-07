package com.apps.realestateapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.realestateapp.R;
import com.apps.realestateapp.model.Apartment;

import java.util.ArrayList;

import android.util.Log;


public class ApartmentListAdapter extends RecyclerView.Adapter<ApartmentListAdapter.ApartmentListViewHolder> {

    Context context;
    ArrayList<Apartment> apartments;

    public ApartmentListAdapter(Context context, ArrayList<Apartment> apartments) {
        this.context    = context;
        this.apartments = apartments;
        Log.v("DEBUG", apartments.get(0).getHREF());
    }

    @NonNull
    @Override
    public ApartmentListAdapter.ApartmentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apartment_item, parent, false);
        return new  ApartmentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentListAdapter.ApartmentListViewHolder holder, int position) {
        holder.apartmentTitle.setText(apartments.get(position).getTitle());
        holder.apartmentHREF.setText(apartments.get(position).getHREF());
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    public class ApartmentListViewHolder extends RecyclerView.ViewHolder{

        TextView apartmentTitle;
        TextView apartmentHREF;

        public ApartmentListViewHolder(@NonNull View itemView) {
            super(itemView);

            apartmentTitle = itemView.findViewById(R.id.apartmentTitle);
            apartmentHREF  = itemView.findViewById(R.id.apartmentHREF);

        }
    }
}
