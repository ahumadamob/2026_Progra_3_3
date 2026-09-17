package com.imb.progra3_3_2026.insumoClinico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/insumos-clinicos")
public class InsumoClinicoController {

    @Autowired
    private InsumoClinicoService service;

    @GetMapping
    public ResponseEntity<List<InsumoClinicoResponseDTO>> getAll() {
        List<InsumoClinico> insumos = service.getAll();
        if (insumos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<InsumoClinicoResponseDTO> dtos = insumos.stream()
                .map(InsumoClinicoMapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsumoClinicoResponseDTO> getById(@PathVariable Long id) {
        InsumoClinico insumo = service.getById(id);
        return ResponseEntity.ok(InsumoClinicoMapper.toResponseDTO(insumo));
    }

    @PostMapping
    public ResponseEntity<InsumoClinicoResponseDTO> create(@RequestBody InsumoClinicoRequestDTO request) {
        InsumoClinico nuevo = service.create(InsumoClinicoMapper.toEntity(request));
        InsumoClinico insumoCargado = service.getById(nuevo.getId());
        return ResponseEntity.ok(InsumoClinicoMapper.toResponseDTO(insumoCargado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsumoClinicoResponseDTO> update(@PathVariable Long id,
                                                @RequestBody InsumoClinicoRequestDTO request) {
        service.update(id, InsumoClinicoMapper.toEntity(request));
        InsumoClinico insumoCargado = service.getById(id);
        return ResponseEntity.ok(InsumoClinicoMapper.toResponseDTO(insumoCargado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}