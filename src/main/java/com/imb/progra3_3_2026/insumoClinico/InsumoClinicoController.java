package com.imb.progra3_3_2026.insumoClinico;

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
@RequestMapping("/api/insumos-clinicos")
public class InsumoClinicoController {

    @Autowired
    private InsumoClinicoService service;

    @GetMapping
    public ResponseEntity<List<InsumoClinico>> getAll() {
        List<InsumoClinico> insumos = service.getAll();
        if (insumos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(insumos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsumoClinico> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InsumoClinico> create(@RequestBody InsumoClinico insumo) {
        InsumoClinico nuevo = service.create(insumo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsumoClinico> update(@PathVariable Long id,
                                                @RequestBody InsumoClinico insumo) {
        return ResponseEntity.ok(service.update(id, insumo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}