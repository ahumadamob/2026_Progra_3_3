package com.imb.progra3_3_2026.insumoClinico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsumoClinicoService {

    @Autowired
    private InsumoClinicoRepository repository;

    public List<InsumoClinico> getAll() {
        return repository.findAll();
    }

    public Optional<InsumoClinico> getById(Long id) {
        return repository.findById(id);
    }

    public InsumoClinico create(InsumoClinico insumo) {
        return repository.save(insumo);
    }

    public InsumoClinico update(Long id, InsumoClinico insumo) {
        insumo.setId(id);
        return repository.save(insumo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}