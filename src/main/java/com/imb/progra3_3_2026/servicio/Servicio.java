package com.imb.progra3_3_2026.servicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private double precioBase;
	private int duracionEstimadaMinutos;
	private boolean requiereTurno;
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
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public int getDuracionEstimadaMinutos() {
		return duracionEstimadaMinutos;
	}
	public void setDuracionEstimadaMinutos(int duracionEstimadaMinutos) {
		this.duracionEstimadaMinutos = duracionEstimadaMinutos;
	}
	public boolean isRequiereTurno() {
		return requiereTurno;
	}
	public void setRequiereTurno(boolean requiereTurno) {
		this.requiereTurno = requiereTurno;
	}
	
	
}
