package com.imb.progra3_3_2026.especialidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadService {
	
	@Autowired
	private EspecialidadRepository repo;
	
	public List<Especialidad> getAll() {
		return repo.findAll();
	}
	
	public Especialidad getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Especialidad create(Especialidad especialidad) {
		return repo.save(especialidad);
	}
	
	public Especialidad update(Especialidad especialidad, Long id) {
		Especialidad actualizarEspecialidad = this.getById(id);
		if(actualizarEspecialidad == null) {
			return null;
		} else {
			especialidad.setId(id);
			return repo.save(especialidad);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}

