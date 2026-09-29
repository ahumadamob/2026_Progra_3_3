package com.imb.progra3_3_2026.vacuna;

import java.time.LocalDateTime;

public class VacunaResponseDTO {

    private Long id;
    private String nombre;
    private EspecieResponseDTO especie;
    private String laboratorio;
    private Integer edadRecomendadaMeses;
    private Boolean refuerzoAnual;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public VacunaResponseDTO() {
    }

    public VacunaResponseDTO(Long id, String nombre, EspecieResponseDTO especie, String laboratorio,
            Integer edadRecomendadaMeses, Boolean refuerzoAnual,
            LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.laboratorio = laboratorio;
        this.edadRecomendadaMeses = edadRecomendadaMeses;
        this.refuerzoAnual = refuerzoAnual;
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

    public EspecieResponseDTO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieResponseDTO especie) {
        this.especie = especie;
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

    public static class EspecieResponseDTO {
        private Long id;
        private String nombre;
        private String descripcion;

        public EspecieResponseDTO() {
        }

        public EspecieResponseDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public EspecieResponseDTO(Long id, String nombre, String descripcion) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
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

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
