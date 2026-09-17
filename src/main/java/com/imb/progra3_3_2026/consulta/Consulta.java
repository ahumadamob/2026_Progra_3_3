package com.imb.progra3_3_2026.consulta;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.mascota.Mascota;
import com.imb.progra3_3_2026.veterinario.Veterinario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime fecha;
	
	@ManyToOne
	private Mascota mascota;
	
	@ManyToOne
	private Veterinario veterinario;
	
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
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
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
