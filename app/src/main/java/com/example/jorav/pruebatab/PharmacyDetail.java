package com.example.jorav.pruebatab;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jorav.pruebatab.Model.Farmacias;

import java.io.IOException;
import java.util.List;

public class PharmacyDetail extends AppCompatActivity {
    FrameLayout frameLayout;
    CollapsingToolbarLayout collapsingToolbar;
    TextView txtAddress,txtHorary,txtPhone;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_detail);

        //Recibimos el objeto farmacia
        Intent intent = getIntent();
        Farmacias farmacia = (Farmacias) intent.getSerializableExtra("farmacia");
        Log.d("DATOS",farmacia.getDireccion());

        //Lamamos al metodo que convierte en longitud y latitud la dirección proporcionada
        getLocationFromAddress(farmacia.getDireccion());
        frameLayout = (FrameLayout) findViewById(R.id.container);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtHorary = (TextView) findViewById(R.id.txtHorary);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle(farmacia.getNombre());
        txtAddress.setText(farmacia.getDireccion());
        txtHorary.setText(farmacia.getHorario());
        txtPhone.setText(farmacia.getTelefono());

        //Con esto añadimos el map al FrameLayout. Le pasamos la id y el objeto MapsActivity
        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.container,new MapsActivity(latitude,longitude,farmacia.getNombre())).commit();


    }

    //Metodo que asigna la latitud y longitud segun una dirección
    public void getLocationFromAddress(String address){
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> addresses = geocoder.getFromLocationName(address,1);
            Log.d("DATOS",addresses.get(0).getLatitude()+" "+addresses.get(0).getLongitude());
            latitude = addresses.get(0).getLatitude();
            longitude= addresses.get(0).getLongitude();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
