package com.imb.progra3_3_2026.veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		@GetMapping ("/veterinarios")
		public ResponseEntity< List<Veterinario>> buscarVeterinarios(){
				List <Veterinario> listaVeterinario = service.getAll();
				if (listaVeterinario.isEmpty()) {
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.ok(listaVeterinario);
						
				}
		}
		
		// Recuperar un solo veterinario
		@GetMapping("/veterinarios/{id}")
		public ResponseEntity<Veterinario> buscarVeterinarioPorId(@PathVariable Long id) {
			Veterinario veterinario = service.getById(id);
			if (veterinario== null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(veterinario);
			}
		}
		
		// Crear nuevo veterinario
		@PostMapping ("/veterinarios")
		public ResponseEntity<Veterinario> crearNuevoVeterinario(@RequestBody Veterinario veterinario ) {
			try {
				Veterinario veterinarioCreado = service.create(veterinario);
				return ResponseEntity.ok(veterinarioCreado);
			}catch (Exception e) {
			return ResponseEntity.badRequest().build();
			}
		}
		// Actualizar veterinario
		@PutMapping("/veterinarios/{id}")
		public ResponseEntity<Veterinario> actualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario ) {
			Veterinario veterinarioDesdeServicio = service.getById(id);
			if (veterinarioDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			}else {
				try {
					Veterinario veterinarioActualizado = service.update(veterinario, id);
					return ResponseEntity.ok(veterinarioActualizado);
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		
		}	
		
		// Eliminar veterinario
		@DeleteMapping("/veterinarios/{id}")
		public ResponseEntity<?> borrarVeterinarioPorId(@PathVariable Long id) {
			
			Veterinario veterinario = service.getById(id);
			if (veterinario==null) {
				return ResponseEntity.notFound().build();
			}else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}
}
