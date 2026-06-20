package com.imb.progra3_3_2026.raza;

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
public class RazaController {
	
	@Autowired
	private RazaService service;
	
	// Recuperar todas
	@GetMapping("/razas")
	public List<Raza> buscarRaza(){
		return service.getALL();
	}
	
	// Recuperar una sola
	@GetMapping("/razas/{id}")
	public Raza buscarRazaPorId(@PathVariable Long id) {
		return service.getById(id);
	}
	
	// Crear nueva raza
	@PostMapping("/razas")
	public Raza crearNuevaRaza(@RequestBody Raza raza ) {
		return service.create(raza);
	}
	
	// Actualizar raza
	@PutMapping("/razas/{id}")
	public Raza actualizarRaza(@PathVariable Long id, @RequestBody Raza raza ) {
		return service.update(raza, id);
	}	
	
	// Eliminar razas
	@DeleteMapping("/razas/{id}")
	public void borrarRazaPorId(@PathVariable Long id) {
		service.delete(id);
	}
}
