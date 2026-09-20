package com.imb.progra3_3_2026.medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;
	
	public List<Medicamento> getAll() {
		return repo.findAll();
	}
	
	public Medicamento getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Medicamento create(Medicamento entity) {
		return repo.save(entity);
	}
	
	public Medicamento update(Long id, Medicamento entity) {
		entity.setId(id);
		return repo.save(entity);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}


