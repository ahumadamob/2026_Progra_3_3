package com.imb.progra3_3_2026.especie;

import com.imb.progra3_3_2026.utils.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Especie extends BaseEntity {
    
	private String nombre;
	private String descripcion;
	private boolean requiereVacunacion;
	private int expectativaVida;

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
	public boolean isRequiereVacunacion() {
		return requiereVacunacion;
	}
	public void setRequiereVacunacion(boolean requiereVacunacion) {
		this.requiereVacunacion = requiereVacunacion;
	}
	public int getExpectativaVida() {
		return expectativaVida;
	}
	public void setExpectativaVida(int expectativaVida) {
		this.expectativaVida = expectativaVida;
	}
}
