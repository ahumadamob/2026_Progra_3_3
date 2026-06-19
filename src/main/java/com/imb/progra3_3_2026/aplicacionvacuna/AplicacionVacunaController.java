package com.imb.progra3_3_2026.aplicacionvacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aplicacionesvacuna")
public class AplicacionVacunaController {

    @Autowired
    private AplicacionVacunaService service;

    @GetMapping
    public List<AplicacionVacuna> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AplicacionVacuna> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AplicacionVacuna create(@RequestBody AplicacionVacuna aplicacionVacuna) {
        return service.create(aplicacionVacuna);
    }

    @PutMapping("/{id}")
    public AplicacionVacuna update(@PathVariable Long id, @RequestBody AplicacionVacuna aplicacionVacuna) {
        return service.update(id, aplicacionVacuna);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}