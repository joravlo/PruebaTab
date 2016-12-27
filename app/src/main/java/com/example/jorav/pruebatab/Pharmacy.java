package com.example.jorav.pruebatab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorav.pruebatab.Model.Farmacias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorav on 20/11/2016.
 */

//Clase que contiene el Fragment de Farmacias
public class Pharmacy extends Fragment {
RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pharmacy, container, false);

        //Creamos una lista de objeto Farmacias
        List<Farmacias> farmaciasList = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerPharmacy);

        //Añadimos unas farmacias a la lista
        farmaciasList.add(new Farmacias("Hospital Casa de Salud","C/ Dr. Manuel Candela, 41","12Km","9:00-18:00","963555777"));
        farmaciasList.add(new Farmacias("Hospital Nisa Valencia al Mar","Río Tajo, 1","12Km","9:00-18:00","963555777"));
        farmaciasList.add(new Farmacias("Hospital Universitario Doctor Peset","Av. de Gaspar Aguilar, 90","12Km","9:00-18:00","963555777"));

        //Declaramos el adaptador y se lo pasamos al recycler
        PharmacyAdapter pharmacyAdapter = new PharmacyAdapter(farmaciasList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(pharmacyAdapter);

        return view;
    }
}

