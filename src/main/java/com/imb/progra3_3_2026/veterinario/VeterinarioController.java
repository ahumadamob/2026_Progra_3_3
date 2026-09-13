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
	
	@GetMapping
	public ResponseEntity<List<VeterinarioResponseDTO>> getAll() {
		List<Veterinario> listaVeterinario = service.getAll();
		if (listaVeterinario.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			List<VeterinarioResponseDTO> response = mapper.toResponseDTOList(listaVeterinario);
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDTO> getById(@PathVariable Long id) {
		Veterinario veterinario = service.getById(id);
		if (veterinario == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(mapper.toResponseDTO(veterinario));
		}
	}
	
	@PostMapping
	public ResponseEntity<VeterinarioResponseDTO> create(@RequestBody VeterinarioRequestDTO dto) {
		try {
			Veterinario veterinario = mapper.toEntity(dto);
			Veterinario veterinarioCreado = service.create(veterinario);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(veterinarioCreado));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDTO> update(@PathVariable Long id, @RequestBody VeterinarioRequestDTO dto) {
		Veterinario veterinarioDesdeServicio = service.getById(id);
		if (veterinarioDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		} else {
			try {
				Veterinario veterinario = mapper.toEntity(dto);
				Veterinario veterinarioActualizado = service.update(id, veterinario);
				return ResponseEntity.ok(mapper.toResponseDTO(veterinarioActualizado));
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Veterinario veterinario = service.getById(id);
		if (veterinario == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	}
}
