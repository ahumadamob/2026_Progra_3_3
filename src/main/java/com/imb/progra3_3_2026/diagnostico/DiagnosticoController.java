package com.imb.progra3_3_2026.diagnostico;

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
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoService service;
	
	@Autowired
	private DiagnosticoMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<DiagnosticoResponseDTO>> getAll() {
		List<Diagnostico> listaDiagnostico = service.getAll();
		if (listaDiagnostico.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(mapper.toResponseDTOList(listaDiagnostico));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiagnosticoResponseDTO> getById(@PathVariable Long id) {
		Diagnostico diagnostico = service.getById(id);
		if (diagnostico == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(mapper.toResponseDTO(diagnostico));
		}
	}
	
	@PostMapping
	public ResponseEntity<DiagnosticoResponseDTO> create(@RequestBody DiagnosticoRequestDTO requestDTO) {
		try {
			Diagnostico entidad = mapper.toEntity(requestDTO);
			Diagnostico diagnosticoCreado = service.create(entidad);
			return ResponseEntity.ok(mapper.toResponseDTO(diagnosticoCreado));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiagnosticoResponseDTO> update(@PathVariable Long id, @RequestBody DiagnosticoRequestDTO requestDTO) {
		Diagnostico diagnosticoExistente = service.getById(id);
		if (diagnosticoExistente == null) {
			return ResponseEntity.notFound().build();
		} else {
			try {
				Diagnostico entidad = mapper.toEntity(requestDTO);
				Diagnostico diagnosticoActualizado = service.update(id, entidad);
				return ResponseEntity.ok(mapper.toResponseDTO(diagnosticoActualizado));
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Diagnostico diagnostico = service.getById(id);
		if (diagnostico == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}


