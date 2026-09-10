package com.imb.progra3_3_2026.especie;

public class EspecieRequestDTO {

    private String nombre;
    private String descripcion;
    private boolean requiereVacunacion;
    private int expectativaVida;

    public EspecieRequestDTO() {
    }

    public EspecieRequestDTO(String nombre, String descripcion, boolean requiereVacunacion, int expectativaVida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requiereVacunacion = requiereVacunacion;
        this.expectativaVida = expectativaVida;
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
}
