package com.imb.progra3_3_2026.especialidad;

import java.time.LocalDateTime;

public class EspecialidadResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String areaClinica;
    private Boolean requiereMatriculaEspecial;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public EspecialidadResponseDTO() {
    }

    public EspecialidadResponseDTO(Especialidad especialidad) {
        this.id = especialidad.getId();
        this.nombre = especialidad.getNombre();
        this.descripcion = especialidad.getDescripcion();
        this.areaClinica = especialidad.getAreaClinica();
        this.requiereMatriculaEspecial = especialidad.getRequiereMatriculaEspecial();
        this.fechaCreacion = especialidad.getFechaCreacion();
        this.fechaActualizacion = especialidad.getFechaActualizacion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAreaClinica() {
        return areaClinica;
    }

    public void setAreaClinica(String areaClinica) {
        this.areaClinica = areaClinica;
    }

    public Boolean getRequiereMatriculaEspecial() {
        return requiereMatriculaEspecial;
    }

    public void setRequiereMatriculaEspecial(Boolean requiereMatriculaEspecial) {
        this.requiereMatriculaEspecial = requiereMatriculaEspecial;
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
}
