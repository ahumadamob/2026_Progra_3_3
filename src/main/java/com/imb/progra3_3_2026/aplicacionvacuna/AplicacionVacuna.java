package com.imb.progra3_3_2026.aplicacionvacuna;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AplicacionVacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vacuna;
    private String mascota;
    private String veterinario;
    private LocalDate fechaAplicacion;
    private LocalDate proximaDosis;
    private String observaciones;

    public AplicacionVacuna() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public LocalDate getProximaDosis() {
        return proximaDosis;
    }

    public void setProximaDosis(LocalDate proximaDosis) {
        this.proximaDosis = proximaDosis;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

