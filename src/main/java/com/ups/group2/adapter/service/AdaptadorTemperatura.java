package com.ups.group2.adapter.service;

//import org.hibernate.mapping.List;
import java.util.List;
import java.util.ArrayList;
//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ups.group2.adapter.model.CelsiusSensor;
import com.ups.group2.adapter.model.FahrenheitSensor;
import com.ups.group2.adapter.model.dto.SensorTemperaturaDTO;
import com.ups.group2.adapter.repository.CelsiusSensorRepository;
import com.ups.group2.adapter.repository.FahrenheitSensorRepository;
import com.ups.group2.adapter.model.dto.*;
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
    public List<SensorTemperaturaDTO> obtenerTemperatura(String bloque) {
        List<SensorTemperaturaDTO> resultados = new ArrayList<>();

        // Consulta primero en la tabla de Celsius
        List<CelsiusSensor> sensoresCelsius = celsiusRepo.findByUbicacion(bloque);
        
        if (!sensoresCelsius.isEmpty()) {
            // Recorremos todos los sensores Celsius encontrados
            for (CelsiusSensor sensorC : sensoresCelsius) {
                SensorTemperaturaDTO dto = new SensorTemperaturaDTO(
                    sensorC.getUbicacion(),
                    sensorC.getValorSensor(),
                    "Celsius"
                );
                resultados.add(dto);
            }
        }
        
        // Busca en la tabla de Fahrenheit
        List<FahrenheitSensor> sensoresFahrenheit = fahrenheitRepo.findByBloque(bloque);
        
        if (!sensoresFahrenheit.isEmpty()) {
            // Recorremos todos los sensores Fahrenheit encontrados
            for (FahrenheitSensor sensorF : sensoresFahrenheit) {
                // Convertimos la temperatura a Celsius
                double temperaturaCelsius = convertirFahrenheitToCelsius(sensorF.getTemperatura());
                SensorTemperaturaDTO dto = new SensorTemperaturaDTO(
                    sensorF.getBloque(),
                    temperaturaCelsius,
                    "Obtenido en Fahrenheit y Convertido a Celsius)"
                );
                resultados.add(dto);
            }
        }
        
        // Si la lista de resultados sigue vacía, lanzamos una excepción
        if (resultados.isEmpty()) {
            throw new EntityNotFoundException("Bloque NO Encontrado en ninguna de las tablas.");
        }

        return resultados;
    }
    
    public double convertirFahrenheitToCelsius(double valorFahrenheit) {
        return (valorFahrenheit - 32) * 5 / 9;
    }
}

