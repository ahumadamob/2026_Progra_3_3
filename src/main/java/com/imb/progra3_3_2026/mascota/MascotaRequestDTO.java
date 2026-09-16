package com.imb.progra3_3_2026.mascota;

import java.time.LocalDate;

public class MascotaRequestDTO {

    private String nombre;
    private LocalDate fechaNacimiento;
    private double peso;
    private Long especieId;
    private Long razaId;
    private Long clienteId;

    public MascotaRequestDTO() {
    }

    public MascotaRequestDTO(String nombre, LocalDate fechaNacimiento, double peso,
                             Long especieId, Long razaId, Long clienteId) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.especieId = especieId;
        this.razaId = razaId;
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public Long getRazaId() {
        return razaId;
    }

    public void setRazaId(Long razaId) {
        this.razaId = razaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
