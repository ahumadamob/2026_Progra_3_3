package com.imb.progra3_3_2026.servicio;

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
public class ServicioController {

    @Autowired
    private ServicioService service;

    @GetMapping("/servicios")
    public ResponseEntity<List<Servicio>> buscarServicio(){
        
    	List<Servicio> listaServicio = service.getAll();
    	
    	if (listaServicio.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	} else {
    		return ResponseEntity.ok(listaServicio);
    	}
    }

    @GetMapping("/servicios/{id}")
    public ResponseEntity<Servicio> buscarServicioPorId(@PathVariable Long id) {
    	
    	Servicio servicio = service.getById(id);
    	if (servicio == null) {
    		return ResponseEntity.notFound().build();
    	} else {
    		return ResponseEntity.ok(servicio);
    	}
    }

    @PostMapping("/servicios")
    public ResponseEntity<Servicio> crearNuevoServicio(@RequestBody Servicio servicio ) {
    	try {
    		Servicio servicioCreda = service.create(servicio);
    		return ResponseEntity.ok(service.create(servicio)); 
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    }

    @PutMapping("/servicios/{id}")
    public ResponseEntity <Servicio> actualizarServicio(@PathVariable Long id, @RequestBody Servicio servicio ) {
    	
    	Servicio servicioDesdeServicio = service.getById(id);
    	if (servicioDesdeServicio == null) {
    		return ResponseEntity.notFound().build();
    	} else {
    		
        	try {
        		Servicio servicioActualizada = service.update(servicio, id);
        		return ResponseEntity.ok(servicioActualizada); 
        	} catch(Exception e) {
        		return ResponseEntity.badRequest().build();
        	}
    	}
    }

    @DeleteMapping("/servicios/{id}")
    public ResponseEntity<?> borrarServicioPorId(@PathVariable Long id) {
    	
    	Servicio servicio = service.getById(id);
    	if (servicio == null) {
    		return ResponseEntity.notFound().build();
    	} else {
    		service.delete(id);
    		return ResponseEntity.ok().build();
    	}
        
    }
}