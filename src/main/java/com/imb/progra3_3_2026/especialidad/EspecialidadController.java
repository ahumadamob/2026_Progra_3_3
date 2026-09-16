package com.imb.progra3_3_2026.especialidad;

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
@RequestMapping("/api/especialidades")
public class EspecialidadController {

	@Autowired
	private EspecialidadService service;

	@Autowired
	private EspecialidadMapper mapper;

	@GetMapping
	public ResponseEntity<List<EspecialidadResponseDTO>> getAll() {
		List<Especialidad> especialidades = service.getAll();
		if (especialidades.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<EspecialidadResponseDTO> response = especialidades.stream()
				.map(mapper::toResponseDTO)
				.toList();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadResponseDTO> getById(@PathVariable Long id) {
		Especialidad especialidad = service.getById(id);
		if (especialidad == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mapper.toResponseDTO(especialidad));
	}

	@PostMapping
	public ResponseEntity<EspecialidadResponseDTO> create(@RequestBody EspecialidadRequestDTO dto) {
		Especialidad nueva = service.create(mapper.toEntity(dto));
		return new ResponseEntity<>(mapper.toResponseDTO(nueva), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EspecialidadResponseDTO> update(@PathVariable Long id,
			@RequestBody EspecialidadRequestDTO dto) {
		Especialidad existente = service.getById(id);
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		mapper.updateEntity(dto, existente);
		Especialidad actualizada = service.update(id, existente);
		return ResponseEntity.ok(mapper.toResponseDTO(actualizada));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Especialidad existente = service.getById(id);
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
