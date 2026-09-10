package com.imb.progra3_3_2026.mascota;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.cliente.Cliente;
import com.imb.progra3_3_2026.especie.Especie;
import com.imb.progra3_3_2026.raza.Raza;

@Component
public class MascotaMapper {

    /**
     * Convierte de MascotaRequestDTO a Mascota (Entidad).
     *
     * @param dto Datos recibidos en la petición.
     * @return Entidad Mascota con sus atributos y relaciones mapeadas.
     */
    public Mascota toEntity(MascotaRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setFechaNacimiento(dto.getFechaNacimiento());
        mascota.setPeso(dto.getPeso());

        if (dto.getEspecieId() != null) {
            Especie especie = new Especie();
            especie.setId(dto.getEspecieId());
            mascota.setEspecie(especie);
        }

        if (dto.getRazaId() != null) {
            Raza raza = new Raza();
            raza.setId(dto.getRazaId());
            mascota.setRaza(raza);
        }

        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());
            mascota.setCliente(cliente);
        }

        return mascota;
    }

    /**
     * Convierte de Mascota (Entidad) a MascotaResponseDTO.
     *
     * @param mascota Entidad Mascota.
     * @return DTO de respuesta con datos de auditoría y relaciones anidadas reducidas.
     */
    public MascotaResponseDTO toResponseDTO(Mascota mascota) {
        if (mascota == null) {
            return null;
        }

        MascotaResponseDTO responseDTO = new MascotaResponseDTO();
        responseDTO.setId(mascota.getId());
        responseDTO.setNombre(mascota.getNombre());
        responseDTO.setFechaNacimiento(mascota.getFechaNacimiento());
        responseDTO.setPeso(mascota.getPeso());
        responseDTO.setFechaCreacion(mascota.getFechaCreacion());
        responseDTO.setFechaActualizacion(mascota.getFechaActualizacion());

        if (mascota.getEspecie() != null) {
            MascotaResponseDTO.EspecieDTO especieDTO = new MascotaResponseDTO.EspecieDTO();
            especieDTO.setId(mascota.getEspecie().getId());
            especieDTO.setNombre(mascota.getEspecie().getNombre());
            responseDTO.setEspecie(especieDTO);
        }

        if (mascota.getRaza() != null) {
            MascotaResponseDTO.RazaDTO razaDTO = new MascotaResponseDTO.RazaDTO();
            razaDTO.setId(mascota.getRaza().getId());
            razaDTO.setNombre(mascota.getRaza().getNombre());
            responseDTO.setRaza(razaDTO);
        }

        if (mascota.getCliente() != null) {
            MascotaResponseDTO.ClienteDTO clienteDTO = new MascotaResponseDTO.ClienteDTO();
            clienteDTO.setId(mascota.getCliente().getId());
            clienteDTO.setNombre(mascota.getCliente().getNombre());
            clienteDTO.setApellido(mascota.getCliente().getApellido());
            responseDTO.setCliente(clienteDTO);
        }

        return responseDTO;
    }

    /**
     * Sobrecarga de conveniencia para toResponseDTO.
     */
    public MascotaResponseDTO toDTO(Mascota mascota) {
        return toResponseDTO(mascota);
    }
}
