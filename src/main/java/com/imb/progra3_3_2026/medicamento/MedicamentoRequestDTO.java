package com.imb.progra3_3_2026.medicamento;

public class MedicamentoRequestDTO {

    private String nombre;
    private String laboratorio;
    private String presentacion;
    private String dosisRecomendada;
    private Boolean requiereReceta;

    public MedicamentoRequestDTO() {
    }

    public MedicamentoRequestDTO(String nombre, String laboratorio, String presentacion,
                                 String dosisRecomendada, Boolean requiereReceta) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.presentacion = presentacion;
        this.dosisRecomendada = dosisRecomendada;
        this.requiereReceta = requiereReceta;
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
}
