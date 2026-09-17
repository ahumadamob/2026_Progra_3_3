package com.imb.progra3_3_2026.tratamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.diagnostico.Diagnostico;
import com.imb.progra3_3_2026.diagnostico.DiagnosticoRepository;
import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;

@Service
public class TratamientoService {
	
	@Autowired
	private TratamientoRepository repo;
	
	@Autowired
	private DiagnosticoRepository diagnosticoRepo;
	
	@Autowired
	private TratamientoMapper mapper;
	
	public List<TratamientoResponseDTO> getAll() {
		List<Tratamiento> tratamientos = repo.findAll();
		return mapper.toResponseDTOList(tratamientos);
	}
	
	public TratamientoResponseDTO getById(Long id) {
		return repo.findById(id)
				.map(mapper::toResponseDTO)
				.orElse(null);
	}
	
	public TratamientoResponseDTO create(TratamientoRequestDTO dto) {
		if (dto == null) {
			return null;
		}
		
		Tratamiento tratamiento = mapper.toEntity(dto);
		
		if (dto.getDiagnosticoId() != null) {
			Diagnostico diagnostico = diagnosticoRepo.findById(dto.getDiagnosticoId())
					.orElseThrow(() -> new ResourceNotFoundException("No se encontró el diagnóstico con ID: " + dto.getDiagnosticoId()));
			tratamiento.setDiagnostico(diagnostico);
		} else {
			tratamiento.setDiagnostico(null);
		}
		
		Tratamiento guardado = repo.save(tratamiento);
		return mapper.toResponseDTO(guardado);
	}
	
	public TratamientoResponseDTO update(Long id, TratamientoRequestDTO dto) {
		if (dto == null) {
			return null;
		}
		
		Tratamiento existente = repo.findById(id).orElse(null);
		if (existente == null) {
			return null;
		}
		
		existente.setFechaInicio(dto.getFechaInicio());
		existente.setFechaFinEstimada(dto.getFechaFinEstimada());
		existente.setDescripcion(dto.getDescripcion());
		existente.setIndicaciones(dto.getIndicaciones());
		
		if (dto.getDiagnosticoId() != null) {
			Diagnostico diagnostico = diagnosticoRepo.findById(dto.getDiagnosticoId())
					.orElseThrow(() -> new ResourceNotFoundException("No se encontró el diagnóstico con ID: " + dto.getDiagnosticoId()));
			existente.setDiagnostico(diagnostico);
		} else {
			existente.setDiagnostico(null);
		}
		
		Tratamiento guardado = repo.save(existente);
		return mapper.toResponseDTO(guardado);
	}

	public TratamientoResponseDTO update(TratamientoRequestDTO dto, Long id) {
		return this.update(id, dto);
	}

	public void delete(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}