package com.imb.progra3_3_2026.especie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository repo;
	
	public List<Especie> getAll(){
		return repo.findAll();
	}
	
	public Especie getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Especie create(Especie especie) {
		return repo.save(especie);
	}
	
	public Especie update(Especie especie,Long id) {
		Especie actualizarEspecie = this.getById(id);
		if(actualizarEspecie == null) {
			return null;
		}else{
		especie.setId(id);
		return repo.save(especie);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
