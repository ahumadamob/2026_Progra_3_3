package com.imb.progra3_3_2026.especie;

import java.time.LocalDateTime;

public class EspecieResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private boolean requiereVacunacion;
    private int expectativaVida;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public EspecieResponseDTO() {
    }

    public EspecieResponseDTO(Long id, String nombre, String descripcion, boolean requiereVacunacion,
                              int expectativaVida, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requiereVacunacion = requiereVacunacion;
        this.expectativaVida = expectativaVida;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public EspecieResponseDTO(Especie especie) {
        if (especie != null) {
            this.id = especie.getId();
            this.nombre = especie.getNombre();
            this.descripcion = especie.getDescripcion();
            this.requiereVacunacion = especie.isRequiereVacunacion();
            this.expectativaVida = especie.getExpectativaVida();
            this.fechaCreacion = especie.getFechaCreacion();
            this.fechaActualizacion = especie.getFechaActualizacion();
        }
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

    public boolean isRequiereVacunacion() {
        return requiereVacunacion;
    }

    public void setRequiereVacunacion(boolean requiereVacunacion) {
        this.requiereVacunacion = requiereVacunacion;
    }

    public int getExpectativaVida() {
        return expectativaVida;
    }

    public void setExpectativaVida(int expectativaVida) {
        this.expectativaVida = expectativaVida;
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
