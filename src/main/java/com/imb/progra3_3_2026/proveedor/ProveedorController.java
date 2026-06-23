package com.imb.progra3_3_2026.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProveedorController {

	@Autowired
	private ProveedorService service;
	
	// Recuperar todos los proveedores
	@GetMapping("/proveedores")
	public ResponseEntity<List<Proveedor>> buscarProveedor(){
		List<Proveedor> proveedores = service.getAll();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		} 
			return ResponseEntity.ok(proveedores);
		
	}
	
	// Recuperar un solo preveedor
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> buscarProveedorPorId(@PathVariable Long id) {
		Proveedor proveedor =service.getById(id);
		if (proveedor == null) {
			 return ResponseEntity.notFound().build();
		} 
			
			return ResponseEntity.ok(proveedor);
		
	}
	
	// Crear nuevo proveedor
	@PostMapping("/proveedor")
	public ResponseEntity<Proveedor> crearNuevoProveedor(@RequestBody Proveedor proveedor ) {
		
		
		if (proveedor.getCuil() == null || proveedor.getRazonSocial()== null) {
			return ResponseEntity.badRequest().body(null);
			
		} 
			Proveedor nuevo = service.create(proveedor);
			
			return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
		
	}
	
	// Actualizar proveedor
	@PatchMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor ) {
		Proveedor existe = service.getById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
			
		} 
		if (proveedor.getCuil() != null) {
			existe.setCuil(proveedor.getCuil());
		} 
		if (proveedor.getDireccion() != null) {
			existe.setDireccion(proveedor.getDireccion());
		} 
		if (proveedor.getEmail() != null) {
			existe.setEmail(proveedor.getEmail());
		} 
		if (proveedor.getRazonSocial() != null) {
			existe.setRazonSocial(proveedor.getRazonSocial());
		} 
		if (proveedor.getRubro() != null) {
			existe.setRubro(proveedor.getRubro());
		} 
		if (proveedor.getTelefono() != null) {
			existe.setTelefono(proveedor.getTelefono());
		} 
		  
			  Proveedor actualizar = service.update(existe, id);
			return ResponseEntity.ok(actualizar);
	}	
	
	// Eliminar proveedor
	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<Void> borrarProveedorPorId(@PathVariable Long id) {
		Proveedor existe = service.getById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
