package com.imb.progra3_3_2026.especialidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EspecialidadController {

	@Autowired
	private EspecialidadService service;
	
	@GetMapping("/especialidades")
	public ResponseEntity<List<Especialidad>> buscarEspecialidad(){
		List<Especialidad> especialidades = service.getAll();

	    if (especialidades.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(especialidades);
	}
	
	@GetMapping("/especialidades/{id}")
	public ResponseEntity<Especialidad> buscarEspecialidadPorId(@PathVariable Long id) {
		Especialidad especialidad = service.getById(id);
		
		if (especialidad == null) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(especialidad);
	}
	
	@PostMapping("/especialidades")
	public ResponseEntity<Especialidad> crearNuevaEspecialidad(@RequestBody Especialidad especialidad) {
		if (especialidad.getNombre() == null || especialidad.getAreaClinica() == null) {
			return ResponseEntity.badRequest().body(null);	
		} 
		
		// Si no viene declarado, se asume que no requiere matrícula especial
		if (especialidad.getRequiereMatriculaEspecial() == null) {
			especialidad.setRequiereMatriculaEspecial(false);
		}
				
		Especialidad nuevaEspecialidad = service.create(especialidad);

		return new ResponseEntity<>(nuevaEspecialidad, HttpStatus.CREATED);
	}
	
	@PatchMapping("/especialidades/{id}")
	public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidad) {
		Especialidad existeEspecialidad = service.getById(id);
		
		if (existeEspecialidad == null) {
			return ResponseEntity.notFound().build();	
		} 
		
		if (especialidad.getNombre() != null) {
			existeEspecialidad.setNombre(especialidad.getNombre());
		} 
		
		if (especialidad.getDescripcion() != null) {
			existeEspecialidad.setDescripcion(especialidad.getDescripcion());
		} 
		if (especialidad.getAreaClinica() != null) {
			existeEspecialidad.setAreaClinica(especialidad.getAreaClinica());
		} 
		
		if (especialidad.getRequiereMatriculaEspecial() != null) {
			existeEspecialidad.setRequiereMatriculaEspecial(especialidad.getRequiereMatriculaEspecial());
		}  
		  
		Especialidad actualizarEspecialidad = service.update(existeEspecialidad, id);
		
		return ResponseEntity.ok(actualizarEspecialidad);
	}
	
	@DeleteMapping("/especialidades/{id}")
	public ResponseEntity<Void> borrarEspecialidadPorId(@PathVariable Long id) {
		Especialidad existeEspecialidad = service.getById(id);
		
		if (existeEspecialidad == null) {
			return ResponseEntity.notFound().build();
		}
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
