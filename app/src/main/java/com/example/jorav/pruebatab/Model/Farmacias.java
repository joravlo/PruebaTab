package com.example.jorav.pruebatab.Model;

import java.io.Serializable;

/**
 * Created by jorav on 18/11/2016.
 */

public class Farmacias implements Serializable {

    String nombre, direccion, distancia,horario,telefono;

    public Farmacias(String nombre, String direccion, String distancia, String horario, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.distancia = distancia;
        this.horario = horario;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
}
