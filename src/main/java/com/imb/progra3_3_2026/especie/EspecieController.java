package com.imb.progra3_3_2026.especie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Especie>> buscarEspecie(){
		
		List<Especie> listaEspecie = service.getAll();
	
		if(listaEspecie.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaEspecie);
		}
		 
	}  
	
	// Recuperar una sola
	@GetMapping("/especies/{id}")
	public ResponseEntity<Especie> buscarEspeciePorId(@PathVariable Long id) {
		
		Especie especie = service.getById(id);
		if(especie == null) {
			return ResponseEntity.notFound().build();
		}else {
			
		}return ResponseEntity.ok(especie);
		 
		
	}
	
	// Crear nueva especie
	@PostMapping("/especies")
	public ResponseEntity<Especie> crearNuevaEspecie(@RequestBody Especie especie) {
		
		try {
			Especie especieCreada = service.create(especie);
			return ResponseEntity.ok(especieCreada);
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		 
	}
	
	// Actualizar la especie
	@PostMapping("/especies/{id}")
	public ResponseEntity<Especie> actualizarEspecie(@PathVariable Long id, @RequestBody Especie especie) {
		Especie especieDesdeServicio = service.getById(id);
		if(especieDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Especie especieActualizada =  service.update(especie, id);
				return ResponseEntity.ok(especieActualizada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		 
	}
	
	// Eliminar especie
	@DeleteMapping("/especies/{id}")
	public ResponseEntity<?> borrarEspecie(@PathVariable Long id) {
		Especie especie = service.getById(id);
		if(especie == null) {
			return ResponseEntity.notFound().build();
		}else{
			service.delete(id);
			return ResponseEntity.ok().build();
			
		}
		
	}
	

}
