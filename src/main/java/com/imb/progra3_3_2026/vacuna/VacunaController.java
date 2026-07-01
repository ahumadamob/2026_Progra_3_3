package com.imb.progra3_3_2026.vacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}") 
    public ResponseEntity <Optional<Vacuna>> getById(@PathVariable Long id) { 
    	Optional<Vacuna> vacuna = vacunaService.getById(id); 
    	
    	if (vacuna == null ) { 
    		return ResponseEntity.notFound().build(); 
    	}else { 
    		return ResponseEntity.ok(vacuna); 
    
    } }

    @PostMapping
    public ResponseEntity<Vacuna> create(@RequestBody Vacuna vacuna) {
        Vacuna nuevaVacuna = vacunaService.create(vacuna);
        return ResponseEntity.ok(nuevaVacuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacuna> update(@PathVariable Long id, @RequestBody Vacuna vacuna) {
        Vacuna vacunaActualizada = vacunaService.update(id, vacuna);

        if (vacunaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vacunaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacunaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}