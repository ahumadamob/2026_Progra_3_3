package com.imb.progra3_3_2026.diagnostico;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.consulta.Consulta;
import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Diagnostico extends BaseEntity {
	@ManyToOne
	private Consulta consulta;
	
	private String descripcion;
	private String gravedad;
	private LocalDateTime fechaDeteccion;
	private String observaciones;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGravedad() {
		return gravedad;
	}
	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}
	public LocalDateTime getFechaDeteccion() {
		return fechaDeteccion;
	}
	public void setFechaDeteccion(LocalDateTime fechaDeteccion) {
		this.fechaDeteccion = fechaDeteccion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
