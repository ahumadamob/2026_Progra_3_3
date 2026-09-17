package com.imb.progra3_3_2026.servicio;

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
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService service;

    @Autowired
    private ServicioMapper mapper;

    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> getAll() {
        List<Servicio> listaServicios = service.getAll();
        if (listaServicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(mapper.toResponseDTOList(listaServicios));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> getById(@PathVariable Long id) {
        Servicio servicio = service.getById(id);
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(mapper.toResponseDTO(servicio));
        }
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDTO> create(@RequestBody ServicioRequestDTO requestDTO) {
        try {
            Servicio entidad = mapper.toEntity(requestDTO);
            Servicio nuevoServicio = service.create(entidad);
            return ResponseEntity.ok(mapper.toResponseDTO(nuevoServicio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> update(@PathVariable Long id, @RequestBody ServicioRequestDTO requestDTO) {
        Servicio servicioExistente = service.getById(id);
        if (servicioExistente == null) {
            return ResponseEntity.notFound().build();
        } else {
            try {
                Servicio entidad = mapper.toEntity(requestDTO);
                Servicio servicioActualizado = service.update(id, entidad);
                return ResponseEntity.ok(mapper.toResponseDTO(servicioActualizado));
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Servicio servicio = service.getById(id);
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}