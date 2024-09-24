package com.ups.group2.adapter.service;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ups.group2.adapter.model.CelsiusSensor;
import com.ups.group2.adapter.model.FahrenheitSensor;
import com.ups.group2.adapter.repository.CelsiusSensorRepository;
import com.ups.group2.adapter.repository.FahrenheitSensorRepository;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdaptadorTemperatura implements RegistroTemperatura {
    
    @Autowired
    private CelsiusSensorRepository celsiusRepo;
    
    @Autowired
    private FahrenheitSensorRepository fahrenheitRepo;

    @Override
    public void registrarTemperatura(String bloque, double temperatura, String tipo) {
        if (tipo.equals("Celsius")) {
            CelsiusSensor sensor = new CelsiusSensor();
            sensor.setUbicacion(bloque);
            sensor.setValorSensor(temperatura);
            celsiusRepo.save(sensor);
        } else if (tipo.equals("Fahrenheit")) {
            FahrenheitSensor sensor = new FahrenheitSensor();
            sensor.setBloque(bloque);
            sensor.setTemperatura(temperatura);
            fahrenheitRepo.save(sensor);
        }
    }

    @Override
    public double obtenerTemperatura(String bloque) {

        // Consulta primero en la tabla de Celsius
        Optional<CelsiusSensor> sensorCelsius = celsiusRepo.findByUbicacion(bloque);
        
        if (sensorCelsius.isPresent()) {
            return sensorCelsius.get().getValorSensor();
        }
        
        // Si no encuentra en Celsius, busca en la tabla de Fahrenheit
        Optional<FahrenheitSensor> sensorFahrenheit = fahrenheitRepo.findByBloque(bloque);
        
        if (sensorFahrenheit.isPresent()) {
            // Convertir de Fahrenheit a Celsius
            return convertirFahrenheitToCelsius(sensorFahrenheit.get().getTemperatura());
        }
        
        // Si no se encuentra en ninguna
        throw new EntityNotFoundException("Bloque NO Encontrado en ninguna de las tablas.");
    }
    
    public double convertirFahrenheitToCelsius(double valorFahrenheit) {
        return (valorFahrenheit - 32) * 5 / 9;
    }
}

