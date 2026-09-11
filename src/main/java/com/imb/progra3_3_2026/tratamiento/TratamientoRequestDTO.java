package com.imb.progra3_3_2026.tratamiento;

import java.time.LocalDateTime;

public class TratamientoRequestDTO {

    private Long diagnosticoId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinEstimada;
    private String descripcion;
    private String indicaciones;

    public TratamientoRequestDTO() {
    }

    public TratamientoRequestDTO(Long diagnosticoId, LocalDateTime fechaInicio, LocalDateTime fechaFinEstimada,
                                 String descripcion, String indicaciones) {
        this.diagnosticoId = diagnosticoId;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.descripcion = descripcion;
        this.indicaciones = indicaciones;
    }

    public Long getDiagnosticoId() {
        return diagnosticoId;
    }

    public void setDiagnosticoId(Long diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public void setFechaFinEstimada(LocalDateTime fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
}
