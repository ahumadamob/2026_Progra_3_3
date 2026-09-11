package com.imb.progra3_3_2026.vacuna;

public class VacunaRequestDTO {

    private String nombre;
    private Long especieId;
    private String laboratorio;
    private Integer edadRecomendadaMeses;
    private Boolean refuerzoAnual;

    public VacunaRequestDTO() {
    }

    public VacunaRequestDTO(String nombre, Long especieId, String laboratorio,
                            Integer edadRecomendadaMeses, Boolean refuerzoAnual) {
        this.nombre = nombre;
        this.especieId = especieId;
        this.laboratorio = laboratorio;
        this.edadRecomendadaMeses = edadRecomendadaMeses;
        this.refuerzoAnual = refuerzoAnual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getEdadRecomendadaMeses() {
        return edadRecomendadaMeses;
    }

    public void setEdadRecomendadaMeses(Integer edadRecomendadaMeses) {
        this.edadRecomendadaMeses = edadRecomendadaMeses;
    }

    public Boolean getRefuerzoAnual() {
        return refuerzoAnual;
    }

    public void setRefuerzoAnual(Boolean refuerzoAnual) {
        this.refuerzoAnual = refuerzoAnual;
    }
}
