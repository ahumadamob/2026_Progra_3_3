package com.imb.progra3_3_2026.raza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/razas")
public class RazaController {

    @Autowired
    private RazaService service;

    @Autowired
    private RazaMapper mapper;

    @GetMapping
    public ResponseEntity<List<RazaResponseDTO>> getAll() {
        List<Raza> razas = service.getAll();

        if (razas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTOList(razas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaResponseDTO> getById(@PathVariable Long id) {
        Raza raza = service.getById(id);

        if (raza == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTO(raza));
    }

    @PostMapping
    public ResponseEntity<RazaResponseDTO> create(@RequestBody RazaRequestDTO dto) {
        try {
            Raza raza = mapper.toEntity(dto);
            Raza nuevaRaza = service.create(raza);
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(nuevaRaza));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RazaResponseDTO> update(@PathVariable Long id, @RequestBody RazaRequestDTO dto) {
        Raza razaExistente = service.getById(id);

        if (razaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            Raza razaParaActualizar = mapper.toEntity(dto);
            Raza razaActualizada = service.update(id, razaParaActualizar);
            return ResponseEntity.ok(mapper.toResponseDTO(razaActualizada));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Raza razaExistente = service.getById(id);

        if (razaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


