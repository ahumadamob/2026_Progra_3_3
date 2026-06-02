package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @GetMapping
    public List<Turno> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Turno obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Turno crear(@RequestBody Turno turno) {
        return service.guardar(turno);
    }

    @PutMapping("/{id}")
    public Turno actualizar(@PathVariable Long id,
                            @RequestBody Turno turno) {
        return service.actualizar(id, turno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}