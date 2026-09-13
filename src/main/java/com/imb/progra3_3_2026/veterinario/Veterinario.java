package com.imb.progra3_3_2026.veterinario;


import com.imb.progra3_3_2026.especialidad.Especialidad;
import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Veterinario extends BaseEntity {
	private String nombre;
	private String apellido;
	private String matricula;
	private String telefono;
	private String email;
	
	@ManyToOne
	@JoinColumn( name= "especialidad_id")
	private Especialidad especialidad;
	
	public Veterinario() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad=especialidad;
	}
	

}
