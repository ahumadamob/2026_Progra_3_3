package com.imb.progra3_3_2026.diagnostico;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class DiagnosticoController {
		
		@Autowired
		private DiagnosticoService service;
		
		// Recuperar todas
		@GetMapping("/diagnosticos")
		public List<Diagnostico> buscarDiagnostico(){
			return service.getAll();
		}
		
		// Recuperar una sola
		@GetMapping("/diagnostico/{id}")
		public Diagnostico buscarDiacnogticoPorId(@PathVariable Long id) {
			return service.getById(id);
		}
		
		// Crear nueva diagnostico
		@PostMapping("/diagnosticos")
		public Diagnostico crearNuevaDiagnostico(@RequestBody Diagnostico diagnostico ) {
			return service.create(diagnostico);
		}
		
		// Actualizar diagnostico
		@PutMapping("/diagnostico/{id}")
		public Diagnostico actualizarDiagnostico(@PathVariable Long id, @RequestBody Diagnostico diagnostico ) {
			return service.update(diagnostico, id);
		}	
		
		// Eliminar diagnostico
		@DeleteMapping("/diagnostico/{id}")
		public void borrarDiacnosticoPorId(@PathVariable Long id) {
			service.delete(id);
		}
	}


