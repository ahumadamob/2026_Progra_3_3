package com.imb.progra3_3_2026.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository repo;
	
	public List<Proveedor> getAll(){
		return repo.findAll();
	}
	
	public Proveedor getById(Long id) {	
		return repo.findById(id).orElse(null);
	}
	
	public Proveedor create(Proveedor proveedor){
		return repo.save(proveedor);
		
	}
	
	public Proveedor update(Proveedor proveedor, Long id) {
		Proveedor actualizarProveedor = this.getById(id);
		if(actualizarProveedor == null) {
			return null;
		}else {
			proveedor.setId(id);
			return repo.save(proveedor);
		}	
		
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
