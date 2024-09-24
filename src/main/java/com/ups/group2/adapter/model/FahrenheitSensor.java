package com.ups.group2.adapter.model;

import jakarta.persistence.*;

//import java.io.Serializable;

@Entity
public class FahrenheitSensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    
    @Column(name="temperatura")
    private double temperatura;

    @Column(name="bloque")
    private String bloque;

    // Getters, Setters, Constructors

    public FahrenheitSensor(Long id, double temperatura, String bloque) {
        this.id = id;
        this.temperatura = temperatura;
        this.bloque = bloque;
    }
   
    public FahrenheitSensor() {
    }

    public Long getId() {
        return id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public String getBloque() {
        return bloque;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }
      
}

