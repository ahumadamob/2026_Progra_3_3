package com.imb.progra3_3_2026.insumoClinico;

import com.imb.progra3_3_2026.proveedor.Proveedor;

public class InsumoClinicoMapper {

    private InsumoClinicoMapper() {}

    /**
     * Convierte un InsumoClinicoRequestDTO en una entidad InsumoClinico nueva.
     * El Proveedor se construye únicamente con el id recibido en el DTO,
     * sin realizar ninguna consulta a la base de datos.
     */
    public static InsumoClinico toEntity(InsumoClinicoRequestDTO dto) {
        InsumoClinico entity = new InsumoClinico();

        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setUnidadMedida(dto.getUnidadMedida());
        entity.setCostoEstimado(dto.getCostoEstimado());
        entity.setRequiereRefrigeracion(dto.getRequiereRefrigeracion());

        if (dto.getProveedorId() != null) {
            Proveedor proveedor = new Proveedor();
            proveedor.setId(dto.getProveedorId());
            entity.setProveedor(proveedor);
        }

        return entity;
    }

    /**
     * Convierte una entidad InsumoClinico en un InsumoClinicoResponseDTO.
     * Incluye los campos heredados de BaseEntity (id, fechaCreacion,
     * fechaActualizacion) y arma el ProveedorResumenDTO anidado.
     */
    public static InsumoClinicoResponseDTO toResponseDTO(InsumoClinico entity) {
        InsumoClinicoResponseDTO dto = new InsumoClinicoResponseDTO();

        dto.setId(entity.getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setUnidadMedida(entity.getUnidadMedida());
        dto.setCostoEstimado(entity.getCostoEstimado());
        dto.setRequiereRefrigeracion(entity.getRequiereRefrigeracion());

        if (entity.getProveedor() != null) {
            Proveedor proveedor = entity.getProveedor();
            ProveedorResumenDTO proveedorResumen = new ProveedorResumenDTO(
                    proveedor.getId(),
                    proveedor.getRazonSocial(),
                    proveedor.getRubro()
            );
            dto.setProveedor(proveedorResumen);
        }

        return dto;
    }
}
