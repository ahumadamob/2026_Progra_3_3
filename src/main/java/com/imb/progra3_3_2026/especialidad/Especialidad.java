package com.imb.progra3_3_2026.especialidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private String areaClinica; 
	private Boolean requiereMatriculaEspecial;
	
	public Especialidad() {

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
