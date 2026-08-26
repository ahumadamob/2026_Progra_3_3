package com.imb.progra3_3_2026.aplicacionvacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacionVacunaService {

    @Autowired
    private AplicacionVacunaRepository repository;

    public List<AplicacionVacuna> getAll() {
        return repository.findAll();
    }

    public Optional<AplicacionVacuna> getById(Long id) {
        return repository.findById(id);
    }

    public AplicacionVacuna create(AplicacionVacuna aplicacionVacuna) {
        return repository.save(aplicacionVacuna);
    }

    public AplicacionVacuna update(Long id, AplicacionVacuna datos) {
        AplicacionVacuna existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrada con id: " + id));

        existente.setVacuna(datos.getVacuna());
        existente.setMascota(datos.getMascota());
        existente.setVeterinario(datos.getVeterinario());
        existente.setFechaAplicacion(datos.getFechaAplicacion());
        existente.setProximaDosis(datos.getProximaDosis());
        existente.setObservaciones(datos.getObservaciones());

        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}