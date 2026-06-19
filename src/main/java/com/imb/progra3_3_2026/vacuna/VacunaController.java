package com.imb.progra3_3_2026.vacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacunas")
public class VacunaController {

    @Autowired
    private VacunaService vacunaService;

    @GetMapping
    public List<Vacuna> getAll() {
        return vacunaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Vacuna> getById(@PathVariable Long id) {
        return vacunaService.getById(id);
    }

    @PostMapping
    public Vacuna create(@RequestBody Vacuna vacuna) {
        return vacunaService.create(vacuna);
    }

    @PutMapping("/{id}")
    public Vacuna update(@PathVariable Long id, @RequestBody Vacuna vacuna) {
        return vacunaService.update(id, vacuna);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vacunaService.delete(id);
    }
}