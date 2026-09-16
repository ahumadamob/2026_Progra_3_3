package com.imb.progra3_3_2026.medicamento;

import java.time.LocalDateTime;

public class MedicamentoResponseDTO {

    private Long id;
    private String nombre;
    private String laboratorio;
    private String presentacion;
    private String dosisRecomendada;
    private Boolean requiereReceta;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public MedicamentoResponseDTO() {
    }

    public MedicamentoResponseDTO(Medicamento medicamento) {
        if (medicamento != null) {
            this.id = medicamento.getId();
            this.nombre = medicamento.getNombre();
            this.laboratorio = medicamento.getLaboratorio();
            this.presentacion = medicamento.getPresentacion();
            this.dosisRecomendada = medicamento.getDosisRecomendada();
            this.requiereReceta = medicamento.getRequiereReceta();
            this.fechaCreacion = medicamento.getFechaCreacion();
            this.fechaActualizacion = medicamento.getFechaActualizacion();
        }
    }

    public MedicamentoResponseDTO(Long id, String nombre, String laboratorio, String presentacion,
                                  String dosisRecomendada, Boolean requiereReceta,
                                  LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.presentacion = presentacion;
        this.dosisRecomendada = dosisRecomendada;
        this.requiereReceta = requiereReceta;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
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

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDosisRecomendada() {
        return dosisRecomendada;
    }

    public void setDosisRecomendada(String dosisRecomendada) {
        this.dosisRecomendada = dosisRecomendada;
    }

    public Boolean getRequiereReceta() {
        return requiereReceta;
    }

    public void setRequiereReceta(Boolean requiereReceta) {
        this.requiereReceta = requiereReceta;
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
}
