package com.imb.progra3_3_2026.mascota;

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
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @Autowired
    private MascotaMapper mapper;

    @GetMapping
    public ResponseEntity<List<MascotaResponseDTO>> getAll() {
        List<Mascota> mascotas = service.getAll();

        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<MascotaResponseDTO> response = mascotas.stream()
                .map(mapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> getById(@PathVariable Long id) {
        Mascota mascota = service.getById(id);

        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTO(mascota));
    }

    @PostMapping
    public ResponseEntity<MascotaResponseDTO> create(@RequestBody MascotaRequestDTO dto) {
        Mascota mascota = mapper.toEntity(dto);
        Mascota nuevaMascota = service.create(mascota);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(nuevaMascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody MascotaRequestDTO dto) {
        Mascota mascota = mapper.toEntity(dto);
        Mascota mascotaActualizada = service.update(id, mascota);

        if (mascotaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTO(mascotaActualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Mascota mascota = service.getById(id);

        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}