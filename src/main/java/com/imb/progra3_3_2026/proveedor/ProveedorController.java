package com.imb.progra3_3_2026.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProveedorController {

	@Autowired
	private ProveedorService service;
	
	// Recuperar todos los proveedores
	@GetMapping("/proveedores")
	public List<Proveedor> buscarProveedor(){
		return service.getAll();
	}
	
	// Recuperar un solo preveedor
	@GetMapping("/proveedor/{id}")
	public Proveedor buscarProveedorPorId(@PathVariable Long id) {
		return service.getById(id);
	}
	
	// Crear nuevo proveedor
	@PostMapping("/proveedor")
	public Proveedor crearNuevoProveedor(@RequestBody Proveedor proveedor ) {
		return service.create(proveedor);
	}
	
	// Actualizar proveedor
	@PutMapping("/proveedor/{id}")
	public Proveedor actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor ) {
		return service.update(proveedor, id);
	}	
	
	// Eliminar proveedor
	@DeleteMapping("/proveedor/{id}")
	public void borrarProveedorPorId(@PathVariable Long id) {
		service.delete(id);
	}
	
}
