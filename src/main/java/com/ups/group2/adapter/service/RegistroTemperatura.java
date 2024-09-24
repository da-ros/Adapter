package com.ups.group2.adapter.service;

//import org.hibernate.mapping.List;
import java.util.List;

import com.ups.group2.adapter.model.dto.SensorTemperaturaDTO;

public interface RegistroTemperatura {
    void registrarTemperatura(String bloque, double temperatura, String tipo);
    List<SensorTemperaturaDTO> obtenerTemperatura(String bloque);
}