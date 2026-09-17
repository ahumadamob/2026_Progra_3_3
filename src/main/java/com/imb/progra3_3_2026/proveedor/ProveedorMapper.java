package com.imb.progra3_3_2026.proveedor;

import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    /**
     * Convierte un objeto ProveedorRequestDTO a una entidad Proveedor.
     * No incluye id ni fechas ya que son manejados por el sistema/base de datos.
     */
    public Proveedor toEntity(ProveedorRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        Proveedor proveedor = new Proveedor();
        proveedor.setRazonSocial(requestDTO.getRazonSocial());
        proveedor.setCuil(requestDTO.getCuil());
        proveedor.setTelefono(requestDTO.getTelefono());
        proveedor.setEmail(requestDTO.getEmail());
        proveedor.setDireccion(requestDTO.getDireccion());
        proveedor.setRubro(requestDTO.getRubro());
        
        // Si existieran relaciones JPA se instanciarían entidades vacías con el id acá (ej: cliente.setId(requestDTO.getClienteId()))
        
        return proveedor;
    }

    /**
     * Convierte una entidad Proveedor a un objeto ProveedorResponseDTO.
     */
    public ProveedorResponseDTO toResponseDTO(Proveedor proveedor) {
        if (proveedor == null) {
            return null;
        }

        ProveedorResponseDTO responseDTO = new ProveedorResponseDTO();
        responseDTO.setId(proveedor.getId());
        responseDTO.setRazonSocial(proveedor.getRazonSocial());
        responseDTO.setCuil(proveedor.getCuil());
        responseDTO.setTelefono(proveedor.getTelefono());
        responseDTO.setEmail(proveedor.getEmail());
        responseDTO.setDireccion(proveedor.getDireccion());
        responseDTO.setRubro(proveedor.getRubro());
        
        // Atributos heredados de BaseEntity
        responseDTO.setFechaCreacion(proveedor.getFechaCreacion());
        responseDTO.setFechaActualizacion(proveedor.getFechaActualizacion());
        
        // Si existieran relaciones JPA se mapearían aquí los datos reducidos (ej: dto.setClienteId(proveedor.getCliente().getId()))

        return responseDTO;
    }
}
