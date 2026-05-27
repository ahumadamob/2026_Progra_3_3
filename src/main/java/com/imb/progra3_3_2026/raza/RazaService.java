package com.imb.progra3_3_2026.raza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaService {
	
	@Autowired
	private RazaRepository repo;
	
	public List<Raza> getALL(){
		return repo.findAll();
	}
	
	public Raza getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void create(Raza raza) {
		repo.save(raza);
	}
	
	public void update(Raza raza, Long id) {
		raza.setId(id);
		repo.save(raza);
	}
	
	public void delete(Long id){
		repo.deleteById(id);
	}

}
