package com.imb.progra3_3_2026.medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping 
	public ResponseEntity<List<Medicamento>> getAll() {
		
		List<Medicamento> listaMedicamento = service.getAll();
		
		if (listaMedicamento.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaMedicamento);
		}
	}
	
	@GetMapping("/medicamento/{id}")
	public ResponseEntity<Medicamento> getById(@PathVariable Long id) {
		
		Medicamento medicamento = service.getById(id);
		if (medicamento == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(medicamento);
		}
	}
	
	@PostMapping
	public ResponseEntity<Medicamento> create(@RequestBody Medicamento medicamento) {
		
		try {
			Medicamento medicamentoCreado = service.create(medicamento);
			return ResponseEntity.ok(medicamentoCreado);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//Actualizar Medicamento
	@PutMapping("/medicamento/{id}")
	public ResponseEntity<Medicamento> update(@PathVariable Long id, @RequestBody Medicamento medicamento ) {
		
		Medicamento medicamentoDesdeServicio = service.getById(id);
		if (medicamentoDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Medicamento medicamentoActualizado = service.update(medicamento, id);
				return ResponseEntity.ok(medicamentoActualizado);
			}catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	// Eliminar Medicamento
	@DeleteMapping("/medicamento/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Medicamento medicamento = service.getById(id);
		if (medicamento == null) {
			return ResponseEntity.notFound().build();
		}else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
	

}
