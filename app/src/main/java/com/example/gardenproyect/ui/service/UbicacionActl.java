package com.example.gardenproyect.ui.service;

public class UbicacionActl {
    Double latitud;
    Double longitud;

    public UbicacionActl() {
    }

    public UbicacionActl(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
