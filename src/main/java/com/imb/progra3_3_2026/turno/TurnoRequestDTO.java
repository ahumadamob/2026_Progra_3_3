package com.imb.progra3_3_2026.turno;

import java.time.LocalDate;
import java.time.LocalTime;

import com.imb.progra3_3_2026.cliente.Cliente;
import com.imb.progra3_3_2026.mascota.Mascota;
import com.imb.progra3_3_2026.veterinario.Veterinario;

public class TurnoRequestDTO {

    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;
    private Long clienteId;
    private Long mascotaId;
    private Long veterinarioId;

    public TurnoRequestDTO() {
    }

    public TurnoRequestDTO(LocalDate fecha, LocalTime hora, String motivo, String estado,
                           Long clienteId, Long mascotaId, Long veterinarioId) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.clienteId = clienteId;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
    }

    public TurnoRequestDTO(LocalDate fecha, String hora, String motivo, String estado,
                           Long clienteId, Long mascotaId, Long veterinarioId) {
        this.fecha = fecha;
        this.hora = (hora != null && !hora.isBlank()) ? LocalTime.parse(hora) : null;
        this.motivo = motivo;
        this.estado = estado;
        this.clienteId = clienteId;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
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

    public void setHora(String hora) {
        this.hora = (hora != null && !hora.isBlank()) ? LocalTime.parse(hora) : null;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public Turno toTurno() {
        Turno turno = new Turno();
        turno.setFecha(this.fecha);
        turno.setHora(this.hora);
        turno.setMotivo(this.motivo);
        turno.setEstado(this.estado);

        if (this.clienteId != null) {
            Cliente cliente = new Cliente();
            cliente.setId(this.clienteId);
            turno.setCliente(cliente);
        }

        if (this.mascotaId != null) {
            Mascota mascota = new Mascota();
            mascota.setId(this.mascotaId);
            turno.setMascota(mascota);
        }

        if (this.veterinarioId != null) {
            Veterinario veterinario = new Veterinario();
            veterinario.setId(this.veterinarioId);
            turno.setVeterinario(veterinario);
        }

        return turno;
    }
}
