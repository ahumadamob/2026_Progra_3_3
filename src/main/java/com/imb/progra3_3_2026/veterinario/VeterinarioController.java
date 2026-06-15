package com.imb.progra3_3_2026.veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService service;
	
		// Recuperar todos los veterinarios
		@GetMapping ("/api/veterinario")
		public List<Veterinario> buscarVeterinarios(){
			return service.getAll();
		}
		
		// Recuperar un solo veterinario
		@GetMapping("/api/veterinario/{id}")
		public Veterinario buscarVeterinarioPorId(@PathVariable Long id) {
			return service.getById(id);
		}
		
		// Crear nuevo veterinario
		@PostMapping ("/api/veterinario")
		public Veterinario crearNuevoVeterinario(@RequestBody Veterinario veterinario ) {
			return service.create(veterinario);
		}
		
		// Actualizar veterinario
		@PutMapping("/api/veterinario/{id}")
		public Veterinario actualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario ) {
			return service.update(veterinario, id);
		}	
		
		// Eliminar veterinario
		@DeleteMapping("/api/veterinario/{id}")
		public void borrarVeterinarioPorId(@PathVariable Long id) {
			service.delete(id);
		}
}
