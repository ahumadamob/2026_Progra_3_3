package com.imb.progra3_3_2026.diagnostico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.consulta.Consulta;
import com.imb.progra3_3_2026.consulta.ConsultaRepository;
import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;

@Service
public class DiagnosticoService {
	
	@Autowired
	private DiagnosticoRepository repo;
	
	@Autowired
	private ConsultaRepository consultaRepo;
	
	public List<Diagnostico> getAll() {
		return repo.findAll();
	}
	
	public Diagnostico getById(Long id) {	
		return repo.findById(id).orElse(null);
	}
	
	public Diagnostico create(Diagnostico diagnostico, Long consultaId) {
		if (consultaId != null) {
			Consulta consulta = consultaRepo.findById(consultaId)
					.orElseThrow(() -> new ResourceNotFoundException("Consulta no encontrada con id: " + consultaId));
			diagnostico.setConsulta(consulta);
		}
		return repo.save(diagnostico);
	}
	
	public Diagnostico update(Long id, Diagnostico diagnostico, Long consultaId) {
		Diagnostico diagnosticoExistente = this.getById(id);
		if (diagnosticoExistente == null) {
			return null;
		} else {
			if (consultaId != null) {
				Consulta consulta = consultaRepo.findById(consultaId)
						.orElseThrow(() -> new ResourceNotFoundException("Consulta no encontrada con id: " + consultaId));
				diagnostico.setConsulta(consulta);
			} else {
				diagnostico.setConsulta(null);
			}
			diagnostico.setId(id);
			return repo.save(diagnostico);
		}	
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}


