package com.imb.progra3_3_2026.mascota;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repository;

    public List<Mascota> getAll() {
        return repository.findAll();
    }

    public Optional<Mascota> getById(Long id) {
        return repository.findById(id);
    }

    public Mascota create(Mascota mascota) {
        return repository.save(mascota);
    }

    public Mascota update(Long id, Mascota mascota) {
        mascota.setId(id);
        return repository.save(mascota);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
