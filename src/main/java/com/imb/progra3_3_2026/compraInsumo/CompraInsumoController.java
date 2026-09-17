package com.imb.progra3_3_2026.compraInsumo;

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
@RequestMapping("/api/compras-insumos")
public class CompraInsumoController {

    @Autowired
    private CompraInsumoService service;

    @Autowired
    private CompraInsumoMapper mapper;

    @GetMapping
    public ResponseEntity<List<CompraInsumoResponseDTO>> getAll() {
        List<CompraInsumo> lista = service.getAll();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTOList(lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraInsumoResponseDTO> getById(@PathVariable Long id) {
        CompraInsumo compraInsumo = service.getById(id);
        if (compraInsumo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTO(compraInsumo));
    }

    @PostMapping
    public ResponseEntity<CompraInsumoResponseDTO> create(@RequestBody CompraInsumoRequestDTO requestDTO) {
        CompraInsumo entidad = mapper.toEntity(requestDTO);
        CompraInsumo nuevo = service.create(entidad);
        return ResponseEntity.ok(mapper.toResponseDTO(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraInsumoResponseDTO> update(@PathVariable Long id,
            @RequestBody CompraInsumoRequestDTO requestDTO) {
        CompraInsumo entidad = mapper.toEntity(requestDTO);
        CompraInsumo actualizado = service.update(id, entidad);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CompraInsumo existente = service.getById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
