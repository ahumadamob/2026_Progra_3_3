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
	
	public Raza create(Raza raza) {
		return repo.save(raza);
	}
	
	public Raza update(Raza raza, Long id) {
		Raza actualizarRaza = this.getById(id);
		if(actualizarRaza == null) {
			return null;
		}else {
			raza.setId(id);
			return repo.save(raza);
		}	
		
	}
	
	public void delete(Long id){
		repo.deleteById(id);
	}

}
