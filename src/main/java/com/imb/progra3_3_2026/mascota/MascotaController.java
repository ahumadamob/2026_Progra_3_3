package com.imb.progra3_3_2026.mascota;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @GetMapping
    public List<Mascota> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mascota> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Mascota create(@RequestBody Mascota mascota) {
        return service.create(mascota);
    }

    @PutMapping("/{id}")
    public Mascota update(@PathVariable Long id,
                          @RequestBody Mascota mascota) {

        return service.update(id, mascota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}