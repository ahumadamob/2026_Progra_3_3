package com.imb.progra3_3_2026.pago;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pago {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String factura;
    private LocalDate fechaPago;
    private double importe;
    private String medioPago;
    private String estado;
    private String comprobante;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComprobante() {
		return comprobante;
	}
	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}
    
    
    

}
