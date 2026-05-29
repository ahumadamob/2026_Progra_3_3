package com.imb.progra3_3_2026.insumoClinico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumo_clinico")
public class InsumoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private String unidadMedida;
    private Double costoEstimado;
    private Boolean requiereRefrigeracion;

    // Constructor vacío 
    public InsumoClinico() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public Double getCostoEstimado() { return costoEstimado; }
    public void setCostoEstimado(Double costoEstimado) { this.costoEstimado = costoEstimado; }

    public Boolean getRequiereRefrigeracion() { return requiereRefrigeracion; }
    public void setRequiereRefrigeracion(Boolean requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }
}
