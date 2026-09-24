package com.imb.progra3_3_2026.turno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TurnoResponseDTO {

    private Long id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;
    private ClienteDTO cliente;
    private MascotaDTO mascota;
    private VeterinarioDTO veterinario;

    public TurnoResponseDTO() {
    }

    public TurnoResponseDTO(Turno turno) {
        if (turno != null) {
            this.id = turno.getId();
            this.fechaCreacion = turno.getFechaCreacion();
            this.fechaActualizacion = turno.getFechaActualizacion();
            this.fecha = turno.getFecha();
            this.hora = turno.getHora();
            this.motivo = turno.getMotivo();
            this.estado = turno.getEstado();
            if (turno.getCliente() != null) {
                this.cliente = new ClienteDTO(
                    turno.getCliente().getId(),
                    turno.getCliente().getNombre(),
                    turno.getCliente().getApellido()
                );
            }
            if (turno.getMascota() != null) {
                this.mascota = new MascotaDTO(
                    turno.getMascota().getId(),
                    turno.getMascota().getNombre()
                );
            }
            if (turno.getVeterinario() != null) {
                this.veterinario = new VeterinarioDTO(
                    turno.getVeterinario().getId(),
                    turno.getVeterinario().getNombre(),
                    turno.getVeterinario().getApellido()
                );
            }
        }
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }

    public VeterinarioDTO getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioDTO veterinario) {
        this.veterinario = veterinario;
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

    public static class MascotaDTO {
        private Long id;
        private String nombre;

        public MascotaDTO() {
        }

        public MascotaDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
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

    public static class VeterinarioDTO {
        private Long id;
        private String nombre;
        private String apellido;

        public VeterinarioDTO() {
        }

        public VeterinarioDTO(Long id, String nombre, String apellido) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
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
