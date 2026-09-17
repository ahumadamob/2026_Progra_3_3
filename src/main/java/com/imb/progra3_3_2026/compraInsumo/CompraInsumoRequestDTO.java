package com.imb.progra3_3_2026.compraInsumo;

import java.time.LocalDateTime;

public class CompraInsumoRequestDTO {

    private Long proveedorId;
    private Long insumoClinicoId;
    private LocalDateTime fechaCompra;
    private int cantidad;
    private double costoTotal;
    private String estado;

    public CompraInsumoRequestDTO() {
    }

    public CompraInsumoRequestDTO(Long proveedorId, Long insumoClinicoId, LocalDateTime fechaCompra,
                                 int cantidad, double costoTotal, String estado) {
        this.proveedorId = proveedorId;
        this.insumoClinicoId = insumoClinicoId;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.estado = estado;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getInsumoClinicoId() {
        return insumoClinicoId;
    }

    public void setInsumoClinicoId(Long insumoClinicoId) {
        this.insumoClinicoId = insumoClinicoId;
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
