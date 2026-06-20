package com.imb.progra3_3_2026.medicamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String laboratorio;
	private String presentacion;
	private String dosisRecomendada; 
	private Boolean requiereReceta;
	
	public Medicamento() {
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getDosisRecomendada() {
		return dosisRecomendada;
	}
	public void setDosisRecomendada(String dosisRecomendada) {
		this.dosisRecomendada = dosisRecomendada;
	}
	public Boolean getRequiereReceta() {
		return requiereReceta;
	}
	public void setRequiereReceta(Boolean requiereReceta) {
		this.requiereReceta = requiereReceta;
	} 
	
	
	
}
