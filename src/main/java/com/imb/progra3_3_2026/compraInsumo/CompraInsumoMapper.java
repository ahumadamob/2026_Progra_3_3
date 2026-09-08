package com.imb.progra3_3_2026.compraInsumo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.insumoClinico.InsumoClinico;
import com.imb.progra3_3_2026.proveedor.Proveedor;

@Component
public class CompraInsumoMapper {

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
            Proveedor proveedor = new Proveedor();
            proveedor.setId(dto.getProveedorId());
            entity.setProveedor(proveedor);
        }

        if (dto.getInsumoClinicoId() != null) {
            InsumoClinico insumoClinico = new InsumoClinico();
            insumoClinico.setId(dto.getInsumoClinicoId());
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
