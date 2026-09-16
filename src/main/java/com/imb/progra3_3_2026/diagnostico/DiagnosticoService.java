package com.imb.progra3_3_2026.diagnostico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService {
	
	@Autowired
	private DiagnosticoRepository repo;
	
	public List<Diagnostico> getAll() {
		return repo.findAll();
	}
	
	public Diagnostico getById(Long id) {	
		return repo.findById(id).orElse(null);
	}
	
	public Diagnostico create(Diagnostico diagnostico) {
		return repo.save(diagnostico);
	}
	
	public Diagnostico update(Long id, Diagnostico diagnostico) {
		Diagnostico diagnosticoExistente = this.getById(id);
		if (diagnosticoExistente == null) {
			return null;
		} else {
			diagnostico.setId(id);
			return repo.save(diagnostico);
		}	
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}


