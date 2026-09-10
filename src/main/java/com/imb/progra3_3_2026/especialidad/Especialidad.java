package com.imb.progra3_3_2026.especialidad;

import com.imb.progra3_3_2026.utils.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Especialidad extends BaseEntity {

	private String nombre;
	private String descripcion;
	private String areaClinica; 
	private Boolean requiereMatriculaEspecial;
	
	public Especialidad() {

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

	public String getAreaClinica() {
		return areaClinica;
	}

	public void setAreaClinica(String areaClinica) {
		this.areaClinica = areaClinica;
	}

	public Boolean getRequiereMatriculaEspecial() {
		return requiereMatriculaEspecial;
	}

	public void setRequiereMatriculaEspecial(Boolean requiereMatriculaEspecial) {
		this.requiereMatriculaEspecial = requiereMatriculaEspecial;
	}
	
}
