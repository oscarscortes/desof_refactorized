package org.oscars.services;

import org.oscars.models.desof.domain.Proveedor;
import org.oscars.repositories.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        return this.proveedorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Proveedor findById(Long id) {
        return this.proveedorRepository.findById(id).orElse(null);
    }
}
