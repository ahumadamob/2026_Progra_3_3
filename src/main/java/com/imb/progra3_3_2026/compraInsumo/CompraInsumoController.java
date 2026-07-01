package com.imb.progra3_3_2026.compraInsumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CompraInsumoController {
	
	@Autowired
	private CompraInsumoService service;
	
	// Recuperar todas
	@GetMapping("/comprainsumos")
	public ResponseEntity<List<CompraInsumo>> buscarCompraInsumo(){
		
		List<CompraInsumo> listaCompraInsumo = service.getAll();
		
		if (listaCompraInsumo.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(listaCompraInsumo);
		}
		
	}
	
	// Recuperar una sola
	@GetMapping("/comprainsumos/{id}")
	public ResponseEntity<CompraInsumo> buscarCompraInsumoPorId(@PathVariable Long id) {
		
		CompraInsumo compraInsumo = service.getById(id);
		if (compraInsumo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(compraInsumo);
		}
	}
	
	// Crear nueva compra insumo
	@PostMapping("/comprainsumos")
	public ResponseEntity<CompraInsumo> crearNuevaCompraInsumo(@RequestBody CompraInsumo compraInsumo) {
		try {
			CompraInsumo compraInsumoCreada = service.create(compraInsumo);
			return ResponseEntity.ok(compraInsumoCreada);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Actualizar la compra insumo
	@PutMapping("/comprainsumos/{id}")
	public ResponseEntity<CompraInsumo> actualizarCompraInsumo(@PathVariable Long id, @RequestBody CompraInsumo compraInsumo) {
		CompraInsumo compraInsumoDesdeServicio = service.getById(id);
		if (compraInsumoDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		} else {
			try {
				CompraInsumo compraInsumoActualizada = service.update(compraInsumo, id);
				return ResponseEntity.ok(compraInsumoActualizada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	// Eliminar compra insumo
	@DeleteMapping("/comprainsumos/{id}")
	public ResponseEntity<?> borrarCompraInsumoPorId(@PathVariable Long id) {
		
		CompraInsumo compraInsumo = service.getById(id);
		if (compraInsumo == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
