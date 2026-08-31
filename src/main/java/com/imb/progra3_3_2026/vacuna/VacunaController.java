package com.imb.progra3_3_2026.vacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacunas")
public class VacunaController {

    @Autowired
    private VacunaService vacunaService;

    @GetMapping
    public ResponseEntity <List<Vacuna>> buscarVacuna() {
    	
    	List <Vacuna> listaVacuna = vacunaService.getAll();
    	
    	if (listaVacuna.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}else {
    		return ResponseEntity.ok(listaVacuna);
    	}
    	
    }

    @GetMapping("/vacuna")
	public ResponseEntity <List<Vacuna>> buscarTratamiento(){
		List<Vacuna> listaVacunas = vacunaService.getAll();
		if (listaVacunas.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(listaVacunas);
		}
	}

    @PostMapping
    public ResponseEntity<Vacuna> create(@RequestBody Vacuna vacuna) {
        Vacuna nuevaVacuna = vacunaService.create(vacuna);
        return ResponseEntity.ok(nuevaVacuna);
    }

    @PutMapping("/vacuna/{id}")
	public ResponseEntity <Vacuna> actualizarVacuna(@PathVariable Long id, @RequestBody Vacuna vacuna ) {
    	Vacuna vacunaDesdeServicio = vacunaService.getById(id);
		if (vacunaDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		} else {
			try {
				Vacuna actualizarVacuna = vacunaService.update(vacuna, id);
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		return null;
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacunaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}