package com.imb.progra3_3_2026.raza;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.especie.Especie;

public class RazaResponseDTO {

    private Long id;
    private String nombre;
    private Double tamanioPromedio;
    private Double pesoPromedio;
    private String observaciones;
    private EspecieDTO especie;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public RazaResponseDTO() {
    }

    public RazaResponseDTO(Long id, String nombre, Double tamanioPromedio, Double pesoPromedio,
                           String observaciones, EspecieDTO especie,
                           LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.tamanioPromedio = tamanioPromedio;
        this.pesoPromedio = pesoPromedio;
        this.observaciones = observaciones;
        this.especie = especie;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public RazaResponseDTO(Raza raza) {
        if (raza != null) {
            this.id = raza.getId();
            this.nombre = raza.getNombre();
            this.tamanioPromedio = raza.getTamanioPromedio();
            this.pesoPromedio = raza.getPesoPromedio();
            this.observaciones = raza.getObservaciones();
            this.fechaCreacion = raza.getFechaCreacion();
            this.fechaActualizacion = raza.getFechaActualizacion();
            if (raza.getEspecie() != null) {
                this.especie = new EspecieDTO(raza.getEspecie());
            }
        }
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

    public Double getTamanioPromedio() {
        return tamanioPromedio;
    }

    public void setTamanioPromedio(Double tamanioPromedio) {
        this.tamanioPromedio = tamanioPromedio;
    }

    public Double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(Double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EspecieDTO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieDTO especie) {
        this.especie = especie;
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

    /**
     * DTO anidado reducido para representar la relación con Especie
     * conteniendo únicamente id y atributos descriptivos.
     */
    public static class EspecieDTO {
        private Long id;
        private String nombre;
        private String descripcion;

        public EspecieDTO() {
        }

        public EspecieDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public EspecieDTO(Long id, String nombre, String descripcion) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public EspecieDTO(Especie especie) {
            if (especie != null) {
                this.id = especie.getId();
                this.nombre = especie.getNombre();
                this.descripcion = especie.getDescripcion();
            }
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
