package com.imb.progra3_3_2026.compraInsumo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompraInsumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String proveedor;
	private String insumoClinico;
	private LocalDateTime fechaCompra;
	private int cantidad;
	private double costoTotal;
	private String estado;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getInsumoClinico() {
		return insumoClinico;
	}
	public void setInsumoClinico(String insumoClinico) {
		this.insumoClinico = insumoClinico;
	}
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
