package com.imb.progra3_3_2026.vacuna;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String laboratorio;
    private Integer edadRecomendadaMeses;
    private Boolean refuerzoAnual;

    public Vacuna() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getEdadRecomendadaMeses() {
        return edadRecomendadaMeses;
    }

    public void setEdadRecomendadaMeses(Integer edadRecomendadaMeses) {
        this.edadRecomendadaMeses = edadRecomendadaMeses;
    }

    public Boolean getRefuerzoAnual() {
        return refuerzoAnual;
    }

    public void setRefuerzoAnual(Boolean refuerzoAnual) {
        this.refuerzoAnual = refuerzoAnual;
    }
}