package com.imb.progra3_3_2026.vacuna;

import com.imb.progra3_3_2026.especie.Especie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @ManyToOne
    private Especie especie;
    
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
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

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}