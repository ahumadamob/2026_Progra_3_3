package com.imb.progra3_3_2026.veterinario;

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
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

	@Autowired
	private VeterinarioService service;

	@Autowired
	private VeterinarioMapper mapper;

	// Recuperar todos los veterinarios en formato ResponseDTO
	@GetMapping
	public ResponseEntity<List<VeterinarioResponseDTO>> getAll() {
		List<Veterinario> listaVeterinario = service.getAll();
		if (listaVeterinario.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<VeterinarioResponseDTO> responseDTOs = listaVeterinario.stream()
				.map(mapper::toResponseDTO)
				.toList();
		return ResponseEntity.ok(responseDTOs);
	}

	// Recuperar un solo veterinario por id en formato ResponseDTO
	@GetMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDTO> getById(@PathVariable Long id) {
		Veterinario veterinario = service.getById(id);
		if (veterinario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mapper.toResponseDTO(veterinario));
	}

	// Crear nuevo veterinario a partir de RequestDTO y devolver ResponseDTO
	@PostMapping
	public ResponseEntity<VeterinarioResponseDTO> create(@RequestBody VeterinarioRequestDTO requestDTO) {
		Veterinario entidad = mapper.toEntity(requestDTO);
		Veterinario veterinarioCreado = service.create(entidad);
		return new ResponseEntity<>(mapper.toResponseDTO(veterinarioCreado), HttpStatus.CREATED);
	}

	// Actualizar veterinario a partir de RequestDTO y devolver ResponseDTO
	@PutMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDTO> update(@PathVariable Long id, @RequestBody VeterinarioRequestDTO requestDTO) {
		Veterinario veterinarioExistente = service.getById(id);
		if (veterinarioExistente == null) {
			return ResponseEntity.notFound().build();
		}
		Veterinario entidad = mapper.toEntity(requestDTO);
		Veterinario veterinarioActualizado = service.update(id, entidad);
		return ResponseEntity.ok(mapper.toResponseDTO(veterinarioActualizado));
	}

	// Eliminar veterinario (sin devolver ResponseDTO)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Veterinario veterinario = service.getById(id);
		if (veterinario == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
