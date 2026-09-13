package com.imb.progra3_3_2026.veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repo;
	
	public List<Veterinario> getAll() {
		return repo.findAll();
	}
	
	public Veterinario getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Veterinario create(Veterinario veterinario) {
		return repo.save(veterinario);
	}
	
	public Veterinario update(Long id, Veterinario veterinario) {
		Veterinario actualizarVeterinario = this.getById(id);
		if(actualizarVeterinario == null) {
			return null;
		} else {
			veterinario.setId(id);
			return repo.save(veterinario);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	

}
