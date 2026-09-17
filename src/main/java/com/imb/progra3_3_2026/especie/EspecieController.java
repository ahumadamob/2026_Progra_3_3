package com.imb.progra3_3_2026.especie;

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
@RequestMapping("/api/especies")
public class EspecieController {
	
	@Autowired
	private EspecieService service;

	@Autowired
	private EspecieMapper mapper;
	
	// Recuperar todas
	@GetMapping
	public ResponseEntity<List<EspecieResponseDTO>> getAll() {
		List<Especie> especies = service.getAll();
		if (especies.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(mapper.toResponseDTOList(especies));
	}
	
	// Recuperar una sola
	@GetMapping("/{id}")
	public ResponseEntity<EspecieResponseDTO> getById(@PathVariable Long id) {
		Especie especie = service.getById(id);
		if (especie == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mapper.toResponseDTO(especie));
	}
	
	// Crear nueva especie
	@PostMapping
	public ResponseEntity<EspecieResponseDTO> create(@RequestBody EspecieRequestDTO requestDTO) {
		try {
			Especie especie = mapper.toEntity(requestDTO);
			Especie especieCreada = service.create(especie);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(especieCreada));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Actualizar la especie
	@PutMapping("/{id}")
	public ResponseEntity<EspecieResponseDTO> update(@PathVariable Long id, @RequestBody EspecieRequestDTO requestDTO) {
		Especie existente = service.getById(id);
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			Especie especie = mapper.toEntity(requestDTO);
			Especie especieActualizada = service.update(id, especie);
			return ResponseEntity.ok(mapper.toResponseDTO(especieActualizada));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Eliminar especie
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Especie especie = service.getById(id);
		if (especie == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
