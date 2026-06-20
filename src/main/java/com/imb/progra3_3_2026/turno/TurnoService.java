package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    public List<Turno> obtenerTodos() {
        return repository.findAll();
    }

    public Turno obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Turno guardar(Turno turno) {
        return repository.save(turno);
    }

    public Turno actualizar(Long id, Turno turnoActualizado) {

        Turno turno = repository.findById(id).orElse(null);

        if (turno != null) {

            turno.setFecha(turnoActualizado.getFecha());
            turno.setHora(turnoActualizado.getHora());
            turno.setCliente(turnoActualizado.getCliente());
            turno.setMascota(turnoActualizado.getMascota());
            turno.setVeterinario(turnoActualizado.getVeterinario());
            turno.setMotivo(turnoActualizado.getMotivo());
            turno.setEstado(turnoActualizado.getEstado());

            return repository.save(turno);
        }

        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}