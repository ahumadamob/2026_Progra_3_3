package com.imb.progra3_3_2026.medicamento;

import com.imb.progra3_3_2026.utils.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Medicamento extends BaseEntity {
	
	private String nombre;
	private String laboratorio;
	private String presentacion;
	private String dosisRecomendada; 
	private Boolean requiereReceta;
	
	public Medicamento() {
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
