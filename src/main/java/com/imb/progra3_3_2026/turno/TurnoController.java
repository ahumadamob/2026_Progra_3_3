package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @Autowired
    private TurnoMapper mapper;

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> getAll() {

        List<Turno> turnos = service.getAll();

        if (turnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTOList(turnos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDTO> getById(@PathVariable Long id) {

        Turno turno = service.getById(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTO(turno));
    }

    @PostMapping
    public ResponseEntity<TurnoResponseDTO> create(@RequestBody TurnoRequestDTO requestDTO) {

        Turno turno = mapper.toEntity(requestDTO);
        Turno nuevoTurno = service.create(turno);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(nuevoTurno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoResponseDTO> update(@PathVariable Long id,
                                                   @RequestBody TurnoRequestDTO requestDTO) {

        Turno turno = mapper.toEntity(requestDTO);
        Turno turnoActualizado = service.update(id, turno);

        if (turnoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTO(turnoActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}