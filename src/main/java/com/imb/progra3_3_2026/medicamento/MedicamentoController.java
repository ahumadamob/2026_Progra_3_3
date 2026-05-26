package com.imb.progra3_3_2026.medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping 
	public List<Medicamento> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/medicamento/{id}")
	public Medicamento getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public Medicamento create(@RequestBody Medicamento medicamento) {
		return service.create(medicamento);
	}
	
	@PutMapping("/medicamento/{id}")
	public Medicamento update(@PathVariable Long id, @RequestBody Medicamento medicamento) {
		return service.update(medicamento, id);
	}
	
	@DeleteMapping("/medicamento/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	
	
	

}
