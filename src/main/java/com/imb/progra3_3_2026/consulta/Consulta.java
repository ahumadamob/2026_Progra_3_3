package com.imb.progra3_3_2026.consulta;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime fecha;
	private String mascota;
	private String veterinario;
	private String motivo; 
	private String observaciones;
	private double pesoRegistrado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getMascota() {
		return mascota;
	}
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public double getPesoRegistrado() {
		return pesoRegistrado;
	}
	public void setPesoRegistrado(double pesoRegistrado) {
		this.pesoRegistrado = pesoRegistrado;
	}
	
	

}
