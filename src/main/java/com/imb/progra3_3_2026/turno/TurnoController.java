package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @GetMapping
    public ResponseEntity<List<Turno>> obtenerTodos() {

        List<Turno> turnos = service.obtenerTodos();

        if (turnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(turnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> obtenerPorId(@PathVariable Long id) {

        Turno turno = service.obtenerPorId(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turno);
    }

    @PostMapping
    public ResponseEntity<Turno> crear(@RequestBody Turno turno) {

        Turno nuevoTurno = service.guardar(turno);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTurno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizar(@PathVariable Long id,
                                            @RequestBody Turno turno) {

        Turno turnoActualizado = service.actualizar(id, turno);

        if (turnoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}