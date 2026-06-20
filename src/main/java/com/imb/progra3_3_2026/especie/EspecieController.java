package com.imb.progra3_3_2026.especie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EspecieController {
	
	@Autowired
	private EspecieService service;
	
	// Recuperar todas
	@GetMapping("/especies")
	public List<Especie> buscarEspecie(){
		return service.getAll();
	}  
	
	// Recuperar una sola
	@GetMapping("/especies/{id}")
	public Especie buscarEspeciePorId(@PathVariable Long id) {
		return service.getById(id);
		
	}
	
	// Crear nueva especie
	@PostMapping("/especies")
	public Especie crearNuevaEspecie(@RequestBody Especie especie) {
		return service.create(especie);
	}
	
	// Actualizar la especie
	@PostMapping("/especies/{id}")
	public Especie actualizarEspecie(@PathVariable Long id, @RequestBody Especie especie) {
		return service.update(especie, id);
	}
	
	// Eliminar especie
	@DeleteMapping("/especies/{id}")
	public void borrarEspecie(@PathVariable Long id) {
		service.delete(id);
	}
	

}
