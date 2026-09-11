package com.imb.progra3_3_2026.servicio;

import java.time.LocalDateTime;

public class ServicioResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private int duracionEstimadaMinutos;
    private boolean requiereTurno;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public ServicioResponseDTO() {
    }

    public ServicioResponseDTO(Long id, String nombre, String descripcion, double precioBase,
                               int duracionEstimadaMinutos, boolean requiereTurno,
                               LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
        this.requiereTurno = requiereTurno;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public ServicioResponseDTO(Servicio servicio) {
        if (servicio != null) {
            this.id = servicio.getId();
            this.nombre = servicio.getNombre();
            this.descripcion = servicio.getDescripcion();
            this.precioBase = servicio.getPrecioBase();
            this.duracionEstimadaMinutos = servicio.getDuracionEstimadaMinutos();
            this.requiereTurno = servicio.isRequiereTurno();
            this.fechaCreacion = servicio.getFechaCreacion();
            this.fechaActualizacion = servicio.getFechaActualizacion();
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

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getDuracionEstimadaMinutos() {
        return duracionEstimadaMinutos;
    }

    public void setDuracionEstimadaMinutos(int duracionEstimadaMinutos) {
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
    }

    public boolean isRequiereTurno() {
        return requiereTurno;
    }

    public void setRequiereTurno(boolean requiereTurno) {
        this.requiereTurno = requiereTurno;
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
