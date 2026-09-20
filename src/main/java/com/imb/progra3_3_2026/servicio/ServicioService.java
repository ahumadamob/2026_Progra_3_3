package com.imb.progra3_3_2026.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {
	
	@Autowired
	private ServicioRepository repo;
	
	public List<Servicio> getAll() {
		return repo.findAll();
	}
	
	public Servicio getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Servicio create(Servicio servicio) {
		return repo.save(servicio);
	}
	
	public Servicio update(Long id, Servicio servicio) {
		Servicio actualizarServicio = this.getById(id);
		if(actualizarServicio == null) {
			return null;
		}else {
			servicio.setId(id);
			return repo.save(servicio);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
