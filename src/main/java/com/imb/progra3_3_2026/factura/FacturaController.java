package com.imb.progra3_3_2026.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FacturaController {
	
	@Autowired
	private FacturaService service;
	
	// Recuperar todas
	@GetMapping("/factura")
	public ResponseEntity<List<Factura>> buscarFactura(){
		
		List<Factura> listaFactura = service.getAll();
	
		if(listaFactura.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaFactura);
		}
		 
	}  
	
	// Recuperar una sola
	@GetMapping("/factura/{id}")
	public ResponseEntity<Factura> buscarFacturaPorId(@PathVariable Long id) {
		
		Factura factura = service.getById(id);
		if(factura == null) {
			return ResponseEntity.notFound().build();
		}else {
			
		}return ResponseEntity.ok(factura);
		 
		
	}
	
	// Crear nueva factura
	@PostMapping("/facturas")
	public ResponseEntity<Factura> crearNuevaFactura(@RequestBody Factura factura) {
		
		try {
			Factura facturaCreada = service.create(factura);
			return ResponseEntity.ok(facturaCreada);
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		 
	}
	
	// Actualizar la factura
	@PostMapping("/factura/{id}")
	public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
		Factura facturaDesdeServicio = service.getById(id);
		if(facturaDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Factura facturaActualizada =  service.update(factura, id);
				return ResponseEntity.ok(facturaActualizada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		 
	}
	
	// Eliminar la factura
	@DeleteMapping("/factura/{id}")
	public ResponseEntity<?> borrarFactura(@PathVariable Long id) {
		Factura factura = service.getById(id);
		if(factura == null) {
			return ResponseEntity.notFound().build();
		}else{
			service.delete(id);
			return ResponseEntity.ok().build();
			
		}
		
	}
	

}
