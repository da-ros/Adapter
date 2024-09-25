package com.ups.group2.adapter.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//import java.io.Serializable;

@Entity
public class CelsiusSensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    
    @Column(name="valor")
    private double valorSensor;

    @Column(name="localidad")
    private String ubicacion;  // 'ubicacion' hace referencia al bloque

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Getters, Setters, Constructors

    public CelsiusSensor(Long id, double valorSensor, String ubicacion) {
        this.id = id;
        this.valorSensor = valorSensor;
        this.ubicacion = ubicacion;
    }

    public CelsiusSensor() {
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public double getValorSensor() {
        return valorSensor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorSensor(double valorSensor) {
        this.valorSensor = valorSensor;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
        
}