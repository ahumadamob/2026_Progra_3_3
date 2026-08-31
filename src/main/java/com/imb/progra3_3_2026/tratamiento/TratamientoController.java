package com.imb.progra3_3_2026.tratamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TratamientoController {

	@Autowired
	private TratamientoService service;
	
	@GetMapping("/tratamientos")
	public ResponseEntity <List<Tratamiento>> buscarTratamiento(){
		List<Tratamiento> listaTratamiento = service.getAll();
		if (listaTratamiento.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(listaTratamiento);
		}
	}
	
	@GetMapping("/tratamiento/{id}")
	public ResponseEntity <Tratamiento> buscarTratamientoPorId(@PathVariable Long id) {
		Tratamiento tratamiento = service.getById(id);
		if (tratamiento == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(tratamiento);
		}
		
	}
	
	@PostMapping("/tratamiento")
	public ResponseEntity <Tratamiento> crearNuevoTratamiento(@RequestBody Tratamiento tratamiento ) {
		try {
			return ResponseEntity.ok(service.create(tratamiento));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/tratamiento/{id}")
	public ResponseEntity <Tratamiento> actualizarTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamiento ) {
		Tratamiento tratamientoDesdeServicio = service.getById(id);
		if (tratamientoDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		} else {
			try {
				Tratamiento tratamientoActualizado = service.update(tratamiento, id);
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		return null;
	}
	
	@DeleteMapping("/tratamientos/{id}")
	public ResponseEntity<?> borrarTratamientoPorId(@PathVariable Long id) {
		Tratamiento tratamiento = service.getById(id);
		if (tratamiento == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
