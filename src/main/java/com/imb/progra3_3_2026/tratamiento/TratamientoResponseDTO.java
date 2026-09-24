package com.imb.progra3_3_2026.tratamiento;

import java.time.LocalDateTime;

public class TratamientoResponseDTO {

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinEstimada;
    private String descripcion;
    private String indicaciones;
    private DiagnosticoDTO diagnostico;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public TratamientoResponseDTO() {
    }

    public TratamientoResponseDTO(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFinEstimada,
                                  String descripcion, String indicaciones, DiagnosticoDTO diagnostico,
                                  LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.descripcion = descripcion;
        this.indicaciones = indicaciones;
        this.diagnostico = diagnostico;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DiagnosticoDTO getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoDTO diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public static class DiagnosticoDTO {
        private Long id;
        private String descripcion;
        private String gravedad;

        public DiagnosticoDTO() {
        }

        public DiagnosticoDTO(Long id, String descripcion, String gravedad) {
            this.id = id;
            this.descripcion = descripcion;
            this.gravedad = gravedad;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
    }
}
