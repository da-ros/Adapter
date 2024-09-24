package com.ups.group2.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ups.group2.adapter.service.AdaptadorTemperatura;

@RestController
@RequestMapping("/temperatura")
public class TemperaturaController {
    
    @Autowired
    private AdaptadorTemperatura adaptadorTemperatura;
    
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarTemperatura(
            @RequestParam String bloque, 
            @RequestParam double temperatura, 
            @RequestParam String tipo) {
        adaptadorTemperatura.registrarTemperatura(bloque, temperatura, tipo);
        return ResponseEntity.ok("Temperatura registrada con éxito.");
    }
    
    @GetMapping("/obtener/{bloque}")
    public ResponseEntity<Double> obtenerTemperatura(@PathVariable String bloque) {
        double temperatura = adaptadorTemperatura.obtenerTemperatura(bloque);
        return ResponseEntity.ok(temperatura);
    }
}
