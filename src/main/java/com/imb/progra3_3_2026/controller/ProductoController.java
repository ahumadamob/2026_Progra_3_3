package com.imb.progra3_3_2026.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imb.progra3_3_2026.entity.Producto;
import com.imb.progra3_3_2026.repository.ProductoRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	private final ProductoRepository productoRepository;
	public ProductoController(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
		
	}
	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	@GetMapping
	public List<Producto> listarProductos(){
		return productoRepository.findAll();
	}

}
