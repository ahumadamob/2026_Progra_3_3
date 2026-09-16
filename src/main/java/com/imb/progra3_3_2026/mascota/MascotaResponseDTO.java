package com.imb.progra3_3_2026.mascota;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.imb.progra3_3_2026.cliente.Cliente;
import com.imb.progra3_3_2026.especie.Especie;
import com.imb.progra3_3_2026.raza.Raza;

public class MascotaResponseDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private double peso;
    private EspecieDTO especie;
    private RazaDTO raza;
    private ClienteDTO cliente;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public MascotaResponseDTO() {
    }

    public MascotaResponseDTO(Long id, String nombre, LocalDate fechaNacimiento, double peso,
                              EspecieDTO especie, RazaDTO raza, ClienteDTO cliente,
                              LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.especie = especie;
        this.raza = raza;
        this.cliente = cliente;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public MascotaResponseDTO(Mascota mascota) {
        if (mascota != null) {
            this.id = mascota.getId();
            this.nombre = mascota.getNombre();
            this.fechaNacimiento = mascota.getFechaNacimiento();
            this.peso = mascota.getPeso();
            this.fechaCreacion = mascota.getFechaCreacion();
            this.fechaActualizacion = mascota.getFechaActualizacion();

            if (mascota.getEspecie() != null) {
                this.especie = new EspecieDTO(mascota.getEspecie());
            }

            if (mascota.getRaza() != null) {
                this.raza = new RazaDTO(mascota.getRaza());
            }

            if (mascota.getCliente() != null) {
                this.cliente = new ClienteDTO(mascota.getCliente());
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public EspecieDTO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieDTO especie) {
        this.especie = especie;
    }

    public RazaDTO getRaza() {
        return raza;
    }

    public void setRaza(RazaDTO raza) {
        this.raza = raza;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
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

    public static class EspecieDTO {
        private Long id;
        private String nombre;

        public EspecieDTO() {
        }

        public EspecieDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public EspecieDTO(Especie especie) {
            if (especie != null) {
                this.id = especie.getId();
                this.nombre = especie.getNombre();
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
    }

    public static class RazaDTO {
        private Long id;
        private String nombre;

        public RazaDTO() {
        }

        public RazaDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public RazaDTO(Raza raza) {
            if (raza != null) {
                this.id = raza.getId();
                this.nombre = raza.getNombre();
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
    }

    public static class ClienteDTO {
        private Long id;
        private String nombre;
        private String apellido;

        public ClienteDTO() {
        }

        public ClienteDTO(Long id, String nombre, String apellido) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public ClienteDTO(Cliente cliente) {
            if (cliente != null) {
                this.id = cliente.getId();
                this.nombre = cliente.getNombre();
                this.apellido = cliente.getApellido();
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
    }
}
