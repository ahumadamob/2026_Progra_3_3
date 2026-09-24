package com.imb.progra3_3_2026.raza;

public class RazaRequestDTO {

    private String nombre;
    private Double tamanioPromedio;
    private Double pesoPromedio;
    private String observaciones;
    private Long especieId;

    public RazaRequestDTO() {
    }

    public RazaRequestDTO(String nombre, Double tamanioPromedio, Double pesoPromedio,
                          String observaciones, Long especieId) {
        this.nombre = nombre;
        this.tamanioPromedio = tamanioPromedio;
        this.pesoPromedio = pesoPromedio;
        this.observaciones = observaciones;
        this.especieId = especieId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTamanioPromedio() {
        return tamanioPromedio;
    }

    public void setTamanioPromedio(Double tamanioPromedio) {
        this.tamanioPromedio = tamanioPromedio;
    }

    public Double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(Double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }
}
