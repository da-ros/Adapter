package com.ups.group2.adapter.model.dto;

public class SensorTemperaturaDTO {
    private String bloque;
    private double temperatura;
    private String tipo;

    public SensorTemperaturaDTO(String bloque, double temperatura, String tipo) {
        this.bloque = bloque;
        this.temperatura = temperatura;
        this.tipo = tipo;
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
