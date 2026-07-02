package com.imb.progra3_3_2026.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
	
	@Autowired
	private FacturaRepository repo;
	
	public List<Factura> getAll(){
		return repo.findAll();
	}
	
	public Factura getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Factura create(Factura factura) {
		return repo.save(factura);
	}
	
	public Factura update(Factura factura,Long id) {
		Factura actualizarFactura = this.getById(id);
		if(actualizarFactura == null) {
			return null;
		}else{
			factura.setId(id);
		return repo.save(factura);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
