package com.ups.group2.adapter.service;

public interface RegistroTemperatura {
    void registrarTemperatura(String bloque, double temperatura, String tipo);
    double obtenerTemperatura(String bloque);
}