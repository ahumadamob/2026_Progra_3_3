package com.imb.progra3_3_2026.veterinario;

import java.time.LocalDateTime;

import com.imb.progra3_3_2026.especialidad.Especialidad;

public class VeterinarioResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;
    private String telefono;
    private String email;
    private EspecialidadDTO especialidad;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public VeterinarioResponseDTO() {
    }

    public VeterinarioResponseDTO(Long id, String nombre, String apellido, String matricula,
                                  String telefono, String email, EspecialidadDTO especialidad,
                                  LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public VeterinarioResponseDTO(Veterinario veterinario) {
        if (veterinario != null) {
            this.id = veterinario.getId();
            this.nombre = veterinario.getNombre();
            this.apellido = veterinario.getApellido();
            this.matricula = veterinario.getMatricula();
            this.telefono = veterinario.getTelefono();
            this.email = veterinario.getEmail();
            this.fechaCreacion = veterinario.getFechaCreacion();
            this.fechaActualizacion = veterinario.getFechaActualizacion();

            if (veterinario.getEspecialidad() != null) {
                this.especialidad = new EspecialidadDTO(veterinario.getEspecialidad());
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EspecialidadDTO getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
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

    public static class EspecialidadDTO {
        private Long id;
        private String nombre;
        private String descripcion;

        public EspecialidadDTO() {
        }

        public EspecialidadDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public EspecialidadDTO(Long id, String nombre, String descripcion) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public EspecialidadDTO(Especialidad especialidad) {
            if (especialidad != null) {
                this.id = especialidad.getId();
                this.nombre = especialidad.getNombre();
                this.descripcion = especialidad.getDescripcion();
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
