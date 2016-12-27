package com.example.jorav.pruebatab;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


//Clase que gestiona el Mapa
public class MapsActivity extends Fragment implements OnMapReadyCallback {

    double latitude,longitude;
    String nameHospital;

    //Creamos un constructor en el cual le pasaremos la latitud, logitud y el nombre del hospital
    public MapsActivity(double latitude, double longitude, String nameHospital) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameHospital = nameHospital;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_maps, container,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //Creamos un objeto LatLng con la latitud y longitud que le habiamos pasado
        LatLng marker = new LatLng(latitude, longitude);

        //Movemos la camara con un zoom de 13 hasta el la posicion dada
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 13));

        //Añadimos el marker. El nombre sera el que le hemos pasado anteriormente y la posición sera la creada anteriormente
        googleMap.addMarker(new MarkerOptions().title(nameHospital).position(marker));
    }
}
