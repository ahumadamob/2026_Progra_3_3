package com.imb.progra3_3_2026.compraInsumo;

import java.time.LocalDateTime;

public class CompraInsumoResponseDTO {

    private Long id;
    private ProveedorDTO proveedor;
    private InsumoClinicoDTO insumoClinico;
    private LocalDateTime fechaCompra;
    private int cantidad;
    private double costoTotal;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public CompraInsumoResponseDTO() {
    }

    public CompraInsumoResponseDTO(Long id, ProveedorDTO proveedor, InsumoClinicoDTO insumoClinico,
                                  LocalDateTime fechaCompra, int cantidad, double costoTotal,
                                  String estado, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.proveedor = proveedor;
        this.insumoClinico = insumoClinico;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public InsumoClinicoDTO getInsumoClinico() {
        return insumoClinico;
    }

    public void setInsumoClinico(InsumoClinicoDTO insumoClinico) {
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

    public static class ProveedorDTO {
        private Long id;
        private String razonSocial;
        private String rubro;

        public ProveedorDTO() {
        }

        public ProveedorDTO(Long id, String razonSocial, String rubro) {
            this.id = id;
            this.razonSocial = razonSocial;
            this.rubro = rubro;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRazonSocial() {
            return razonSocial;
        }

        public void setRazonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
        }

        public String getRubro() {
            return rubro;
        }

        public void setRubro(String rubro) {
            this.rubro = rubro;
        }
    }

    public static class InsumoClinicoDTO {
        private Long id;
        private String nombre;
        private String tipo;

        public InsumoClinicoDTO() {
        }

        public InsumoClinicoDTO(Long id, String nombre, String tipo) {
            this.id = id;
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
    }
}
