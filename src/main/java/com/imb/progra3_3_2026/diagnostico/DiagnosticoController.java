package com.imb.progra3_3_2026.diagnostico;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
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
		public ResponseEntity <List<Diagnostico>> buscarDiagnostico(){
			List <Diagnostico>listaDiagnostico = service.getAll();
			if (listaDiagnostico.isEmpty()) {
				return ResponseEntity.noContent().build();
				
			}else {
				return ResponseEntity.ok(listaDiagnostico);
			}
			
		}
		
		// Recuperar una sola
		@GetMapping("/diagnosticos/{id}")
		public ResponseEntity <Diagnostico >buscarDiagnosticoPorId(@PathVariable Long id) {
			Diagnostico diagnostico = service.getById(id);
			if (diagnostico== null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(diagnostico);
				
			}	
				
			
			
		}
		
		// Crear nueva diagnostico
		@PostMapping("/diagnosticos")
		public ResponseEntity <Diagnostico> crearNuevoDiagnostico(@RequestBody Diagnostico diagnostico ) {
			try {
				Diagnostico diagnosticoCreda = service.create(diagnostico);
				 return ResponseEntity.ok(diagnosticoCreda);
			}catch(Exception e ) {
				 return ResponseEntity.badRequest().build();
			}
			
		}
		
		// Actualizar diagnostico
		@PutMapping("/diagnosticos/{id}")
		public ResponseEntity < Diagnostico> actualizarDiagnostico(@PathVariable Long id, @RequestBody Diagnostico diagnostico ) {
			Diagnostico dagnosticoDesdeServicio = service.getById(id);
			if (dagnosticoDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			}else {
				try {
					Diagnostico diagnosticoActualisada = service.update(diagnostico, id);
					 return ResponseEntity.ok(diagnosticoActualisada);
				}catch(Exception e ) {
					 return ResponseEntity.badRequest().build();
				}
				
			}	
				
			
			
		}
			
			
		
		// Eliminar diagnostico
		@DeleteMapping("/diagnosticos/{id}")
		public ResponseEntity <?>borrarDiacnosticoPorId(@PathVariable Long id) {
			Diagnostico diagnostico = service.getById(id);
			if (diagnostico== null) {
				return ResponseEntity.notFound().build();
			}else {
				service.delete(id);
				return ResponseEntity.ok().build();
				
			}	
				
			
		}
	}


