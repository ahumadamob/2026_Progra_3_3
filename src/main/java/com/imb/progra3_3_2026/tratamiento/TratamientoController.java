package com.imb.progra3_3_2026.tratamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/tratamientos")
public class TratamientoController {

	@Autowired
	private TratamientoService service;
	
	@GetMapping
	public ResponseEntity<List<TratamientoResponseDTO>> getAll() {
		List<TratamientoResponseDTO> listaTratamiento = service.getAll();
		if (listaTratamiento.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(listaTratamiento);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TratamientoResponseDTO> getById(@PathVariable Long id) {
		TratamientoResponseDTO tratamiento = service.getById(id);
		if (tratamiento == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(tratamiento);
		}
	}
	
	@PostMapping
	public ResponseEntity<TratamientoResponseDTO> create(@RequestBody TratamientoRequestDTO tratamientoDTO) {
		TratamientoResponseDTO nuevoTratamiento = service.create(tratamientoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTratamiento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TratamientoResponseDTO> update(@PathVariable Long id, @RequestBody TratamientoRequestDTO tratamientoDTO) {
		TratamientoResponseDTO tratamientoActualizado = service.update(id, tratamientoDTO);
		if (tratamientoActualizado == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(tratamientoActualizado);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		TratamientoResponseDTO tratamiento = service.getById(id);
		if (tratamiento == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	}
}
