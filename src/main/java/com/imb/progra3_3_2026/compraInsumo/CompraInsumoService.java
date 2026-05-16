package com.imb.progra3_3_2026.compraInsumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraInsumoService {
	
	@Autowired
	private CompraInsumoRepository repo;
	
	public List<CompraInsumo> getAll() {
		return repo.findAll();
	}
	
	public CompraInsumo getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void create(CompraInsumo compraInsumo) {
		repo.save(compraInsumo);
	}
	
	public void update(CompraInsumo compraInsumo, Long id) {
		compraInsumo.setId(id);
		repo.save(compraInsumo);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
