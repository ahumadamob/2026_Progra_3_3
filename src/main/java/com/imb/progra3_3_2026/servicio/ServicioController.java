package com.imb.progra3_3_2026.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioController {

    @Autowired
    private ServicioService service;

    @GetMapping("/servicios")
    public List<Servicio> buscarServicio(){
        return service.getAll();
    }

    @GetMapping("/servicios/{id}")
    public Servicio buscarServicioPorId(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/servicios")
    public Servicio crearNuevoServicio(@RequestBody Servicio servicio ) {
        return service.create(servicio);
    }

    @PutMapping("/servicios/{id}")
    public Servicio actualizarServicio(@PathVariable Long id, @RequestBody Servicio servicio ) {
        return service.update(servicio, id);
    }

    @DeleteMapping("/consultas/{id}")
    public void borrarConsultaPorId(@PathVariable Long id) {
        service.delete(id);
    }
}