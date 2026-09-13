package com.imb.progra3_3_2026.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saludos")
public class SaludoController {
	
	@GetMapping
	 public String saludar() {
	 return "Hola desde Spring Boot";
	 }
	
	@PostMapping
	 public String saludarConNombre(@RequestBody SaludoRequest request) {
	 return "Hola " + request.getNombre() + ", tu peticion fue recibida correctamente";
	 }
}
