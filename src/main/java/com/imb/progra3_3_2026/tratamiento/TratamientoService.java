package com.imb.progra3_3_2026.tratamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService {
	
	@Autowired
	private TratamientoRepository repo;
	
	public List<Tratamiento> getAll(){
		return repo.findAll();
	}
	
	public Tratamiento getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Tratamiento create(Tratamiento tratamiento) {
		return repo.save(tratamiento);
	}
	
	public Tratamiento update(Tratamiento tratamiento,Long id) {
		Tratamiento actualizarTratamiento = this.getById(id);
		if(actualizarTratamiento == null) {
			return null;
		}else{
		tratamiento.setId(id);
		return repo.save(tratamiento);
		}
	}


	public void delete(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}