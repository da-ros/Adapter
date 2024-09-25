package com.ups.group2.adapter.model.dto;

import java.time.LocalDateTime;

public class SensorTemperaturaDTO {
    private String bloque;
    private double temperatura;
    private String tipo;
    private LocalDateTime fechaRegistro;

    public SensorTemperaturaDTO(String bloque, double temperatura, String tipo, LocalDateTime fechaRegistro) {
        this.bloque = bloque;
        this.temperatura = temperatura;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
