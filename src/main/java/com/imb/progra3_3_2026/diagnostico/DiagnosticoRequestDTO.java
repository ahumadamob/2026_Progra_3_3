package com.imb.progra3_3_2026.diagnostico;

import java.time.LocalDateTime;

public class DiagnosticoRequestDTO {

    private Long consultaId;
    private String descripcion;
    private String gravedad;
    private LocalDateTime fechaDeteccion;
    private String observaciones;

    public DiagnosticoRequestDTO() {
    }

    public DiagnosticoRequestDTO(Long consultaId, String descripcion, String gravedad, LocalDateTime fechaDeteccion, String observaciones) {
        this.consultaId = consultaId;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.fechaDeteccion = fechaDeteccion;
        this.observaciones = observaciones;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDateTime getFechaDeteccion() {
        return fechaDeteccion;
    }

    public void setFechaDeteccion(LocalDateTime fechaDeteccion) {
        this.fechaDeteccion = fechaDeteccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
