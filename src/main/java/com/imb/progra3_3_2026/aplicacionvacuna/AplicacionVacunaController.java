package com.imb.progra3_3_2026.aplicacionvacuna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aplicaciones-vacuna")
public class AplicacionVacunaController {

    @Autowired
    private AplicacionVacunaService service;

    @GetMapping
    public ResponseEntity<List<AplicacionVacuna>> getAll() {
        List<AplicacionVacuna> lista = service.getAll();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicacionVacuna> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AplicacionVacuna> create(@RequestBody AplicacionVacuna aplicacion) {
        AplicacionVacuna nueva = service.create(aplicacion);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AplicacionVacuna> update(@PathVariable Long id,
                                                    @RequestBody AplicacionVacuna aplicacion) {
        return ResponseEntity.ok(service.update(id, aplicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
