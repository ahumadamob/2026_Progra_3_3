package com.imb.progra3_3_2026.servicio;

import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;

@Entity
public class Servicio extends BaseEntity {
	
	private String nombre;
	private String descripcion;
	private double precioBase;
	private int duracionEstimadaMinutos;
	private boolean requiereTurno;
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
