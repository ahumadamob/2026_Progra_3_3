package com.imb.progra3_3_2026.medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;
	
	public List <Medicamento> getAll(){
		return repo.findAll();
	}
	
	public Medicamento getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Medicamento create(Medicamento medicamento){
		return repo.save(medicamento);
	}
	
	public Medicamento update (Medicamento medicamento, Long id) {
		medicamento.setId(id);
		return repo.save(medicamento);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}


