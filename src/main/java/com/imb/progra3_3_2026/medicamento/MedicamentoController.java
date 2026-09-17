package com.imb.progra3_3_2026.medicamento;

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
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@Autowired
	private MedicamentoMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<MedicamentoResponseDTO>> getAll() {
		List<Medicamento> lista = service.getAll();
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<MedicamentoResponseDTO> responseList = mapper.toResponseDTOList(lista);
		return ResponseEntity.ok(responseList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicamentoResponseDTO> getById(@PathVariable Long id) {
		Medicamento medicamento = service.getById(id);
		if (medicamento == null) {
			return ResponseEntity.notFound().build();
		}
		MedicamentoResponseDTO responseDTO = mapper.toResponseDTO(medicamento);
		return ResponseEntity.ok(responseDTO);
	}
	
	@PostMapping
	public ResponseEntity<MedicamentoResponseDTO> create(@RequestBody MedicamentoRequestDTO requestDTO) {
		try {
			Medicamento entity = mapper.toEntity(requestDTO);
			Medicamento medicamentoCreado = service.create(entity);
			MedicamentoResponseDTO responseDTO = mapper.toResponseDTO(medicamentoCreado);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicamentoResponseDTO> update(@PathVariable Long id, @RequestBody MedicamentoRequestDTO requestDTO) {
		Medicamento medicamentoExistente = service.getById(id);
		if (medicamentoExistente == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			Medicamento entity = mapper.toEntity(requestDTO);
			Medicamento medicamentoActualizado = service.update(id, entity);
			MedicamentoResponseDTO responseDTO = mapper.toResponseDTO(medicamentoActualizado);
			return ResponseEntity.ok(responseDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Medicamento medicamento = service.getById(id);
		if (medicamento == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
