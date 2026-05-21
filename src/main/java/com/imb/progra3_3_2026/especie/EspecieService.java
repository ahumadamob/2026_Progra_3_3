package com.imb.progra3_3_2026.especie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class EspecieService {
	
	@Autowired
	private EspecieRepository repo;
	
	public List<Especie> getAll(){
		return repo.findAll();
	}
	
	public Especie getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void create(Especie especie) {
		repo.save(especie);
	}
	
	public void update(Especie especie,Long id) {
		especie.setId(id);
		repo.save(especie);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
