package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    public List<Turno> getAll() {
        return repository.findAll();
    }

    public Turno getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Turno create(Turno entity) {
        return repository.save(entity);
    }

    public Turno update(Long id, Turno entity) {

        Turno turno = repository.findById(id).orElse(null);

        if (turno != null) {

            turno.setFecha(entity.getFecha());
            turno.setHora(entity.getHora());
            turno.setCliente(entity.getCliente());
            turno.setMascota(entity.getMascota());
            turno.setVeterinario(entity.getVeterinario());
            turno.setMotivo(entity.getMotivo());
            turno.setEstado(entity.getEstado());

            return repository.save(turno);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}