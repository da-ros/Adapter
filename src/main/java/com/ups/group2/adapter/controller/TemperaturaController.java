package com.ups.group2.adapter.controller;

//import org.hibernate.mapping.List;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ups.group2.adapter.model.dto.SensorTemperaturaDTO;
import com.ups.group2.adapter.service.AdaptadorTemperatura;
import com.ups.group2.adapter.service.RegistroTemperatura;

@RestController
@RequestMapping("/temperatura")
public class TemperaturaController {
    
    @Autowired
    private RegistroTemperatura adaptadorTemperatura;
    
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarTemperatura(
            @RequestBody SensorTemperaturaDTO sensorTemperaturaDTO) {
        adaptadorTemperatura.registrarTemperatura(sensorTemperaturaDTO.getBloque(), sensorTemperaturaDTO.getTemperatura(), sensorTemperaturaDTO.getTipo());
        return ResponseEntity.ok("Temperatura registrada con éxito.");
    }
    
    @GetMapping("/obtener/{bloque}")
    public ResponseEntity<List<SensorTemperaturaDTO>> obtenerTemperatura(@PathVariable String bloque) {
        List<SensorTemperaturaDTO> temperaturas = adaptadorTemperatura.obtenerTemperatura(bloque);
        return ResponseEntity.ok(temperaturas);
    }

    @GetMapping("/obtenerTodasMediciones")
    public ResponseEntity<List<SensorTemperaturaDTO>> obtenerTodasMediciones() {
        List<SensorTemperaturaDTO> todasLasTemperaturas = adaptadorTemperatura.obtenerTodasLasMediciones();
        return ResponseEntity.ok(todasLasTemperaturas);
    }


}
