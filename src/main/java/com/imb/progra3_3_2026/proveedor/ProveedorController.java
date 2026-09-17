package com.imb.progra3_3_2026.proveedor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired
	private ProveedorMapper mapper;
	
	// Recuperar todos los proveedores
	@GetMapping("/api/proveedores")
	public ResponseEntity<List<ProveedorResponseDTO>> buscarProveedor(){
		List<Proveedor> proveedores = service.getAll();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		} 
		List<ProveedorResponseDTO> dtos = proveedores.stream()
				.map(mapper::toResponseDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
		
	}
	
	// Recuperar un solo preveedor
	@GetMapping("/api/proveedores/{id}")
	public ResponseEntity<ProveedorResponseDTO> buscarProveedorPorId(@PathVariable Long id) {
		Proveedor proveedor =service.getById(id);
		if (proveedor == null) {
			 return ResponseEntity.notFound().build();
		} 
			
		return ResponseEntity.ok(mapper.toResponseDTO(proveedor));
		
	}
	
	// Crear nuevo proveedor
	@PostMapping("/api/proveedores")
	public ResponseEntity<ProveedorResponseDTO> crearNuevoProveedor(@RequestBody ProveedorRequestDTO requestDTO ) {
		
		
		if (requestDTO.getCuil() == null || requestDTO.getRazonSocial()== null) {
			return ResponseEntity.badRequest().body(null);
			
		} 
		Proveedor proveedor = mapper.toEntity(requestDTO);
		Proveedor nuevo = service.create(proveedor);
		
		return new ResponseEntity<>(mapper.toResponseDTO(nuevo), HttpStatus.CREATED);
		
	}
	
	// Actualizar proveedor
	@PutMapping("/api/proveedores/{id}")
	public ResponseEntity<ProveedorResponseDTO> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorRequestDTO requestDTO ) {
		Proveedor existe = service.getById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
			
		} 
		  
		Proveedor proveedorAActualizar = mapper.toEntity(requestDTO);
		Proveedor actualizar = service.update(id, proveedorAActualizar);
		return ResponseEntity.ok(mapper.toResponseDTO(actualizar));
	}	
	
	// Eliminar proveedor
	@DeleteMapping("/api/proveedores/{id}")
	public ResponseEntity<Void> borrarProveedorPorId(@PathVariable Long id) {
		Proveedor existe = service.getById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
