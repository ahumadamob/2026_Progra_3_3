package com.imb.progra3_3_2026.raza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazaController {

    @Autowired
    private RazaService service;

    // Recuperar todas
    @GetMapping("/razas")
    public ResponseEntity<List<Raza>> buscarRaza() {

        List<Raza> listaRaza = service.getALL();

        if (listaRaza.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listaRaza);
        }
    }

    // Recuperar una sola
    @GetMapping("/razas/{id}")
    public ResponseEntity<Raza> buscarRazaPorId(@PathVariable Long id) {

        Raza raza = service.getById(id);

        if (raza == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(raza);
        }
    }

    // Crear nueva raza
    @PostMapping("/razas")
    public ResponseEntity<Raza> crearNuevaRaza(@RequestBody Raza raza) {

        try {
            Raza razaCreada = service.create(raza);
            return ResponseEntity.ok(razaCreada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar raza
    @PutMapping("/razas/{id}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable Long id, @RequestBody Raza raza) {

        Raza razaDesdeServicio = service.getById(id);

        if (razaDesdeServicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            try {
                Raza razaActualizada = service.update(raza, id);
                return ResponseEntity.ok(razaActualizada);
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
    }

    // Eliminar raza
    @DeleteMapping("/razas/{id}")
    public ResponseEntity<?> borrarRaza(@PathVariable Long id) {

        Raza raza = service.getById(id);

        if (raza == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
