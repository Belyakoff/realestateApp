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
        holder.apartmentRayon.setText(apartments.get(position).getRayon());
        holder.apartmentAdress.setText(apartments.get(position).getAdress());
        holder.apartmentPrice.setText(String.valueOf(apartments.get(position).getPrice()));
        holder.apartmentSubprice.setText(apartments.get(position).getSubprice());
        holder.apartmentPhoneNumber.setText(apartments.get(position).getPhoneNumber());
        holder.apartmentDescription.setText(apartments.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    public class ApartmentListViewHolder extends RecyclerView.ViewHolder{

        TextView apartmentTitle;
        TextView apartmentHREF;
        TextView apartmentRayon;
        TextView apartmentAdress;
        TextView apartmentPrice;
        TextView apartmentSubprice;
        TextView apartmentPhoneNumber;
        TextView apartmentDescription;

        public ApartmentListViewHolder(@NonNull View itemView) {
            super(itemView);

            apartmentTitle       = itemView.findViewById(R.id.apartmentTitle);
            apartmentHREF        = itemView.findViewById(R.id.apartmentHREF);
            apartmentRayon       = itemView.findViewById(R.id.apartmentRayon);
            apartmentAdress      = itemView.findViewById(R.id.apartmentAdress);
            apartmentPrice       = itemView.findViewById(R.id.apartmentPrice);
            apartmentSubprice    = itemView.findViewById(R.id.apartmentSubprice);
            apartmentPhoneNumber = itemView.findViewById(R.id.apartmentPhoneNumber);
            apartmentDescription = itemView.findViewById(R.id.apartmentDescription);
        }
    }
}
