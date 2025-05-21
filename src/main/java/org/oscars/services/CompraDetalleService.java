package org.oscars.services;

import org.oscars.models.desof.domain.Compra;
import org.oscars.models.desof.domain.CompraDetalle;
import org.oscars.repositories.CompraDetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraDetalleService {

    private final CompraDetalleRepository compraDetalleRepository;

    public CompraDetalleService(CompraDetalleRepository compraDetalleRepository) {
        this.compraDetalleRepository = compraDetalleRepository;
    }

    @Transactional(readOnly = true)
    public List<CompraDetalle> findAll() {
        return this.compraDetalleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CompraDetalle findById(Long id) {
        return this.compraDetalleRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<CompraDetalle> findByCompraId(Long compraId) {
        return this.compraDetalleRepository.findAllByCompra_Id(compraId);
    }

    @Transactional(readOnly = true)
    public List<CompraDetalle> findByInventarioId(Long inventarioId) {
        return this.compraDetalleRepository.findAllByInventario_Id(inventarioId);
    }
}
