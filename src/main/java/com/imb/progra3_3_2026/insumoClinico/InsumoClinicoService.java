package com.imb.progra3_3_2026.insumoClinico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;
import com.imb.progra3_3_2026.proveedor.Proveedor;
import com.imb.progra3_3_2026.proveedor.ProveedorRepository;

@Service
public class InsumoClinicoService {

    @Autowired
    private InsumoClinicoRepository repository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<InsumoClinico> getAll() {
        return repository.findAll();
    }

    public InsumoClinico getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "InsumoClinico no encontrado con id: " + id));
    }

    public InsumoClinico create(InsumoClinico insumo) {
        resolverProveedor(insumo);
        return repository.save(insumo);
    }

    public InsumoClinico update(Long id, InsumoClinico insumo) {
        insumo.setId(id);
        resolverProveedor(insumo);
        return repository.save(insumo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Si el insumo trae un Proveedor con solo el id, lo reemplaza por el
     * Proveedor completo cargado desde la base. Lanza ResourceNotFoundException
     * si el id de proveedor no existe.
     */
    private void resolverProveedor(InsumoClinico insumo) {
        if (insumo.getProveedor() != null && insumo.getProveedor().getId() != null) {
            Long proveedorId = insumo.getProveedor().getId();
            Proveedor proveedor = proveedorRepository.findById(proveedorId)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Proveedor no encontrado con id: " + proveedorId));
            insumo.setProveedor(proveedor);
        }
    }
}