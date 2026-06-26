package com.imb.progra3_3_2026.consulta;

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
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	// Recuperar todas
	@GetMapping("/consultas")
	public ResponseEntity<List<Consulta>>  buscarConsulta(){
		
		List<Consulta> listaConsulta = service.getAll();
		
		if (listaConsulta.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaConsulta);
		}	
		
	}
	
	// Recuperar una sola
	@GetMapping("/consultas/{id}")
	public ResponseEntity<Consulta>  buscarConsultaPorId(@PathVariable Long id) {
		
		Consulta consulta = service.getById(id);
		if(consulta == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(consulta);
		}
	}
	
	// Crear nueva consulta
	@PostMapping("/consultas")
	public ResponseEntity<Consulta> crearNuevaConsulta(@RequestBody Consulta consulta ) {
		try {
			Consulta consultaCreda = service.create(consulta);
			return ResponseEntity.ok(consultaCreda);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}		
	}
	
	// Actualizar consulta
	@PutMapping("/consultas/{id}")
	public ResponseEntity<Consulta> actualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta ) {
		
		Consulta consultaDesdeServicio = service.getById(id);
		if(consultaDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Consulta consultaActualizada= service.update(consulta, id);
				return ResponseEntity.ok(consultaActualizada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}	
	}	
	
	// Eliminar consulta
	@DeleteMapping("/consultas/{id}")
	public ResponseEntity<?> borrarConsultaPorId(@PathVariable Long id) {
		
		Consulta consulta = service.getById(id);
		if(consulta == null) {
			return ResponseEntity.notFound().build();
		}else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		
	}
}
