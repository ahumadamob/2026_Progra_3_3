package com.imb.progra3_3_2026.turno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.cliente.Cliente;
import com.imb.progra3_3_2026.cliente.ClienteRepository;
import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;
import com.imb.progra3_3_2026.mascota.Mascota;
import com.imb.progra3_3_2026.mascota.MascotaRepository;
import com.imb.progra3_3_2026.veterinario.Veterinario;
import com.imb.progra3_3_2026.veterinario.VeterinarioRepository;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Turno> getAll() {
        return repository.findAll();
    }

    public Turno getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Turno create(Turno entity) {
        resolverRelaciones(entity);
        return repository.save(entity);
    }

    public Turno update(Long id, Turno entity) {

        Turno turno = repository.findById(id).orElse(null);

        if (turno != null) {
            resolverRelaciones(entity);

            turno.setFecha(entity.getFecha());
            turno.setHora(entity.getHora());
            turno.setCliente(entity.getCliente());
            turno.setMascota(entity.getMascota());
            turno.setVeterinario(entity.getVeterinario());
            turno.setMotivo(entity.getMotivo());
            turno.setEstado(entity.getEstado());

            return repository.save(turno);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Recupera y valida las entidades asociadas (Cliente, Mascota y Veterinario)
     * desde sus respectivos repositorios para asegurar que sean instancias gestionadas.
     * Lanza ResourceNotFoundException si alguno de los IDs indicados no existe.
     */
    private void resolverRelaciones(Turno turno) {
        if (turno.getCliente() != null && turno.getCliente().getId() != null) {
            Long clienteId = turno.getCliente().getId();
            Cliente cliente = clienteRepository.findById(clienteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));
            turno.setCliente(cliente);
        }

        if (turno.getMascota() != null && turno.getMascota().getId() != null) {
            Long mascotaId = turno.getMascota().getId();
            Mascota mascota = mascotaRepository.findById(mascotaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con id: " + mascotaId));
            turno.setMascota(mascota);
        }

        if (turno.getVeterinario() != null && turno.getVeterinario().getId() != null) {
            Long veterinarioId = turno.getVeterinario().getId();
            Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con id: " + veterinarioId));
            turno.setVeterinario(veterinario);
        }
    }
}