package org.oscars.services;

import org.oscars.models.desof.domain.Sucursal;
import org.oscars.repositories.SucursalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Transactional(readOnly = true)
    public List<Sucursal> findAll() {
        return this.sucursalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sucursal findById(Long id) {
        return this.sucursalRepository.findById(id).orElse(null);
    }
}
