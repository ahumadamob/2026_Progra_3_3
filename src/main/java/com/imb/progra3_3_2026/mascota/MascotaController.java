package com.imb.progra3_3_2026.mascota;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @GetMapping
    public ResponseEntity<List<Mascota>> getAll() {

        List<Mascota> mascotas = service.getAll();

        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getById(@PathVariable Long id) {

        Optional<Mascota> mascota = service.getById(id);

        if (mascota.isPresent()) {
            return ResponseEntity.ok(mascota.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Mascota> create(@RequestBody Mascota mascota) {

        Mascota nuevaMascota = service.create(mascota);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id,
                                          @RequestBody Mascota mascota) {

        Optional<Mascota> existente = service.getById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Mascota mascotaActualizada = service.update(id, mascota);

        return ResponseEntity.ok(mascotaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Optional<Mascota> mascota = service.getById(id);

        if (mascota.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}