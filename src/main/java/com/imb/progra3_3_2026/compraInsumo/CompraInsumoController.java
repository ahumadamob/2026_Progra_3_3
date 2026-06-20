package com.imb.progra3_3_2026.compraInsumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<CompraInsumo> buscarCompraInsumo(){
		return service.getAll();
	}
	
	// Recuperar una sola
	@GetMapping("/comprainsumos/{id}")
	public CompraInsumo buscarCompraInsumoPorId(@PathVariable Long id) {
		return service.getById(id);
	}
	
	// Crear nueva compra insumo
	@PostMapping("/comprainsumos")
	public CompraInsumo crearNuevaCompraInsumo(@RequestBody CompraInsumo compraInsumo) {
		return service.create(compraInsumo);
	}
	
	// Actualizar la compra insumo
	@PutMapping("/comprainsumos/{id}")
	public CompraInsumo actualizarCompraInsumo(@PathVariable Long id, @RequestBody CompraInsumo compraInsumo) {
		return service.update(compraInsumo, id);
	}
	
	// Eliminar compra insumo
	@DeleteMapping("/comprainsumos/{id}")
	public void borrarCompraInsumoPorId(@PathVariable Long id) {
		service.delete(id);
	}
}
