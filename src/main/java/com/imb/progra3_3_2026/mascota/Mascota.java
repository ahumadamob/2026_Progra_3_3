package com.imb.progra3_3_2026.mascota;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.imb.progra3_3_2026.cliente.Cliente;
import com.imb.progra3_3_2026.especie.Especie;
import com.imb.progra3_3_2026.raza.Raza;
import com.imb.progra3_3_2026.utils.BaseEntity;

@Entity
public class Mascota extends BaseEntity {
	
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "especie_id")
	private Especie especie;

	@ManyToOne
	@JoinColumn(name = "raza_id")
	private Raza raza;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private LocalDate fechaNacimiento;
	private double peso;
	
	public Mascota() {
	}

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
	public Raza getRaza() {
	    return raza;
	}

	public void setRaza(Raza raza) {
	    this.raza = raza;
	}
	public Cliente getCliente() {
	    return cliente;
	}

	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
