package com.imb.progra3_3_2026.compraInsumo;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.insumoClinico.InsumoClinico;
import com.imb.progra3_3_2026.proveedor.Proveedor;
import com.imb.progra3_3_2026.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CompraInsumo extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "insumoClinico_id")
	private InsumoClinico insumoClinico;
	
	private LocalDateTime fechaCompra;
	private int cantidad;
	private double costoTotal;
	private String estado;
	
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public InsumoClinico getInsumoClinico() {
		return insumoClinico;
	}
	public void setInsumoClinico(InsumoClinico insumoClinico) {
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
