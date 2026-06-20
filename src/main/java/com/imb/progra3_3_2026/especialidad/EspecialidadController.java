package com.imb.progra3_3_2026.especialidad;

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
public class EspecialidadController {

	@Autowired
	private EspecialidadService service;
	
	@GetMapping("/especialidades")
	public List<Especialidad> buscarEspecialidad(){
		return service.getAll();
	}
	
	@GetMapping("/especialidades/{id}")
	public Especialidad buscarEspecialidadPorId(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/especialidades")
	public Especialidad crearNuevaEspecialidad(@RequestBody Especialidad especialidad) {
		return service.create(especialidad);
	}
	
	@PutMapping("/especialidades/{id}")
	public Especialidad actualizarEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidad) {
		return service.update(especialidad, id);
	}
	
	@DeleteMapping("/especialidades/{id}")
	public void borrarEspecialidadPorId(@PathVariable Long id) {
		service.delete(id);
	}
}
