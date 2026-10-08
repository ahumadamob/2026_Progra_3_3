package com.imb.progra3_3_2026.compraInsumo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;
import com.imb.progra3_3_2026.insumoClinico.InsumoClinico;
import com.imb.progra3_3_2026.insumoClinico.InsumoClinicoRepository;
import com.imb.progra3_3_2026.proveedor.Proveedor;
import com.imb.progra3_3_2026.proveedor.ProveedorRepository;

@Component
public class CompraInsumoMapper {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private InsumoClinicoRepository insumoClinicoRepository;

    public CompraInsumoMapper() {
    }

    public CompraInsumoMapper(ProveedorRepository proveedorRepository, InsumoClinicoRepository insumoClinicoRepository) {
        this.proveedorRepository = proveedorRepository;
        this.insumoClinicoRepository = insumoClinicoRepository;
    }

    public CompraInsumo toEntity(CompraInsumoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        CompraInsumo entity = new CompraInsumo();
        entity.setFechaCompra(dto.getFechaCompra());
        entity.setCantidad(dto.getCantidad());
        entity.setCostoTotal(dto.getCostoTotal());
        entity.setEstado(dto.getEstado());

        if (dto.getProveedorId() != null) {
            Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + dto.getProveedorId()));
            entity.setProveedor(proveedor);
        }

        if (dto.getInsumoClinicoId() != null) {
            InsumoClinico insumoClinico = insumoClinicoRepository.findById(dto.getInsumoClinicoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Insumo clínico no encontrado con ID: " + dto.getInsumoClinicoId()));
            entity.setInsumoClinico(insumoClinico);
        }

        return entity;
    }

    public CompraInsumoResponseDTO toResponseDTO(CompraInsumo entity) {
        if (entity == null) {
            return null;
        }

        CompraInsumoResponseDTO dto = new CompraInsumoResponseDTO();
        dto.setId(entity.getId());
        dto.setFechaCompra(entity.getFechaCompra());
        dto.setCantidad(entity.getCantidad());
        dto.setCostoTotal(entity.getCostoTotal());
        dto.setEstado(entity.getEstado());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getProveedor() != null) {
            CompraInsumoResponseDTO.ProveedorDTO proveedorDTO = new CompraInsumoResponseDTO.ProveedorDTO(
                    entity.getProveedor().getId(),
                    entity.getProveedor().getRazonSocial(),
                    entity.getProveedor().getRubro()
            );
            dto.setProveedor(proveedorDTO);
        }

        if (entity.getInsumoClinico() != null) {
            CompraInsumoResponseDTO.InsumoClinicoDTO insumoClinicoDTO = new CompraInsumoResponseDTO.InsumoClinicoDTO(
                    entity.getInsumoClinico().getId(),
                    entity.getInsumoClinico().getNombre(),
                    entity.getInsumoClinico().getTipo()
            );
            dto.setInsumoClinico(insumoClinicoDTO);
        }

        return dto;
    }

    public List<CompraInsumoResponseDTO> toResponseDTOList(List<CompraInsumo> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
