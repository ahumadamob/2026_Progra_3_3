package com.imb.progra3_3_2026.raza;

import com.imb.progra3_3_2026.especie.Especie;
import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Raza extends BaseEntity {

	private String nombre;
	private double tamanioPromedio;
	private double pesoPromedio;
	private String observaciones;
	@ManyToOne
	@JoinColumn(name = "especie_id")
	private Especie especie;

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
