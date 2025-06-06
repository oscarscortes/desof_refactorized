package org.oscars.services;

import org.oscars.models.desof.domain.Inventario;
import org.oscars.repositories.InventarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Inventario> findAll() {
        return this.inventarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Inventario findById(Long id) {
        return this.inventarioRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Inventario> findBySucursal(Long sucursalId) {
        return this.inventarioRepository.findAllBySucursal_Id(sucursalId);
    }

    @Transactional(readOnly = true)
    public List<Inventario> findByProducto(Long codigo) {
        return this.inventarioRepository.findAllByProducto_Codigo(codigo);
    }
}
