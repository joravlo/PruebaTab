package com.example.jorav.pruebatab;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jorav.pruebatab.Model.Farmacias;

import java.util.List;

/**
 * Created by jorav on 18/11/2016.
 */

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder> {
    List<Farmacias> listPharmacy;
    Context context;

    //Recibimos una lista de farmacias
    public PharmacyAdapter(List<Farmacias> listPharmacy,Context context) {
        this.listPharmacy = listPharmacy;
        this.context = context;
    }

    @Override
    public PharmacyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacy_recycler_view,parent,false);
        return new PharmacyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PharmacyViewHolder holder, final int position) {
        //A cada elemento de la view le añadimos la informacion necesaria
        holder.txtDistance.setText(listPharmacy.get(position).getDistancia());
        holder.txtNameHospital.setText(listPharmacy.get(position).getNombre());
        holder.txtAddress.setText(listPharmacy.get(position).getDireccion());
        holder.imageArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si pulsamos en la imagen de la flecha iremos al Detalle de farmacia y le pasaremos el objeto farmacia
                Intent intent = new Intent(context,PharmacyDetail.class);
                intent.putExtra("farmacia",listPharmacy.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listPharmacy.size();
    }

    public static class PharmacyViewHolder extends RecyclerView.ViewHolder{
        TextView txtNameHospital, txtAddress, txtDistance;
        ImageView imageArrow;
            public PharmacyViewHolder(View itemView) {
                super(itemView);
                txtNameHospital = (TextView) itemView.findViewById(R.id.txtNameHospital);
                txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
                txtDistance = (TextView) itemView.findViewById(R.id.txtDistance);
                imageArrow = (ImageView) itemView.findViewById(R.id.imageArrow);
            }
        }
}
