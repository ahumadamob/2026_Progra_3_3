package com.imb.progra3_3_2026.aplicacionvacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aplicaciones-vacuna")
public class AplicacionVacunaController {

    @Autowired
    private AplicacionVacunaService service;

    @GetMapping
    public List<AplicacionVacuna> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicacionVacuna> getById(@PathVariable Long id) {
        return service.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AplicacionVacuna create(@RequestBody AplicacionVacuna aplicacionVacuna) {
        return service.create(aplicacionVacuna);
    }

    @PutMapping("/{id}")
    public AplicacionVacuna update(@PathVariable Long id, @RequestBody AplicacionVacuna datos) {
        return service.update(id, datos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}