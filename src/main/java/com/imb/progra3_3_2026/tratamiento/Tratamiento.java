package com.imb.progra3_3_2026.tratamiento;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.diagnostico.Diagnostico;
import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento extends BaseEntity {
	
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFinEstimada;
	
	@ManyToOne
	private Diagnostico diagnostico;
	
	private String descripcion; 
	private String indicaciones;
	
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFinEstimada() {
		return fechaFinEstimada; 
	}
	public void setFechaFinEstimada(LocalDateTime fechaFinEstimada) {
		this.fechaFinEstimada = fechaFinEstimada;
	}
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	
}