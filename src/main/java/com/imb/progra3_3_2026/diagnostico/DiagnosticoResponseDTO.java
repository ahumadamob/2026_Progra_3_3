package com.imb.progra3_3_2026.diagnostico;

import java.time.LocalDateTime;

public class DiagnosticoResponseDTO {

    private Long id;
    private String descripcion;
    private String gravedad;
    private LocalDateTime fechaDeteccion;
    private String observaciones;
    private ConsultaDTO consulta;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public DiagnosticoResponseDTO() {
    }

    public DiagnosticoResponseDTO(Long id, String descripcion, String gravedad, LocalDateTime fechaDeteccion,
                                  String observaciones, ConsultaDTO consulta, LocalDateTime fechaCreacion,
                                  LocalDateTime fechaActualizacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.fechaDeteccion = fechaDeteccion;
        this.observaciones = observaciones;
        this.consulta = consulta;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
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

    public ConsultaDTO getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaDTO consulta) {
        this.consulta = consulta;
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

    public static class ConsultaDTO {
        private Long id;
        private LocalDateTime fecha;
        private String motivo;

        public ConsultaDTO() {
        }

        public ConsultaDTO(Long id, LocalDateTime fecha, String motivo) {
            this.id = id;
            this.fecha = fecha;
            this.motivo = motivo;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public String getMotivo() {
            return motivo;
        }

        public void setMotivo(String motivo) {
            this.motivo = motivo;
        }
    }
}
