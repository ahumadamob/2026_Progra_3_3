package com.imb.progra3_3_2026.servicio;

public class ServicioRequestDTO {

    private String nombre;
    private String descripcion;
    private double precioBase;
    private int duracionEstimadaMinutos;
    private boolean requiereTurno;

    public ServicioRequestDTO() {
    }

    public ServicioRequestDTO(String nombre, String descripcion, double precioBase,
                              int duracionEstimadaMinutos, boolean requiereTurno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
        this.requiereTurno = requiereTurno;
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
}
