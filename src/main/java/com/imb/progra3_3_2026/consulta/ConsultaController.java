package com.imb.progra3_3_2026.consulta;

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
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	// Recuperar todas
	@GetMapping("/consultas")
	public List<Consulta> buscarConsulta(){
		return service.getAll();
	}
	
	// Recuperar una sola
	@GetMapping("/consultas/{id}")
	public Consulta buscarConsultaPorId(@PathVariable Long id) {
		return service.getById(id);
	}
	
	// Crear nueva consulta
	@PostMapping("/consultas")
	public Consulta crearNuevaConsulta(@RequestBody Consulta consulta ) {
		return service.create(consulta);
	}
	
	// Actualizar consulta
	@PutMapping("/consultas/{id}")
	public Consulta actualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta ) {
		return service.update(consulta, id);
	}	
	
	// Eliminar consulta
	@DeleteMapping("/consultas/{id}")
	public void borrarConsultaPorId(@PathVariable Long id) {
		service.delete(id);
	}
}
