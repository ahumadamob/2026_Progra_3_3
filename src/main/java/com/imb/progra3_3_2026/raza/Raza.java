package com.imb.progra3_3_2026.raza;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Raza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String especie;
	private double tamanioPromedio;
	private double pesoPromedio;
	private String observaciones;
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public double getTamanioPromedio() {
		return tamanioPromedio;
	}
	public void setTamanioPromedio(double tamanioPromedio) {
		this.tamanioPromedio = tamanioPromedio;
	}
	public double getPesoPromedio() {
		return pesoPromedio;
	}
	public void setPesoPromedio(double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	
}
