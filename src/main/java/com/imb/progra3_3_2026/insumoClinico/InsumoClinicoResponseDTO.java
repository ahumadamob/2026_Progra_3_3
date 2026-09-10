package com.imb.progra3_3_2026.insumoClinico;

import java.time.LocalDateTime;

public class InsumoClinicoResponseDTO {

    // Heredados de BaseEntity
    private Long id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    // Propios de InsumoClinico
    private String nombre;
    private String tipo;
    private String unidadMedida;
    private Double costoEstimado;
    private Boolean requiereRefrigeracion;

    // Proveedor resumido
    private ProveedorResumenDTO proveedor;

    public InsumoClinicoResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(Double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public Boolean getRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    public void setRequiereRefrigeracion(Boolean requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    public ProveedorResumenDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorResumenDTO proveedor) {
        this.proveedor = proveedor;
    }
}
