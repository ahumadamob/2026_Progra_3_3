package com.imb.progra3_3_2026.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repo;
	
	public List<Consulta> getAll(){
		return repo.findAll();
	}
	
	public Consulta getById(Long id) {	
		return repo.findById(id).orElse(null);
	}
	
	public Consulta create(Consulta consulta){
		return repo.save(consulta);
		
	}
	
	public Consulta update(Consulta consulta, Long id) {
		Consulta actualizarConsulta = this.getById(id);
		if(actualizarConsulta == null) {
			return null;
		}else {
			consulta.setId(id);
			return repo.save(consulta);
		}	
		
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
