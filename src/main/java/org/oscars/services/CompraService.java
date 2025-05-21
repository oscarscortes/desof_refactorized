package org.oscars.services;

import org.oscars.models.desof.domain.Compra;
import org.oscars.repositories.CompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;


    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Transactional(readOnly = true)
    public List<Compra> findAll() {
        return this.compraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Compra findById(Long id) {
        return this.compraRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Compra> findByClienteId(Long clienteId) {
        return this.compraRepository.findAllByCliente_Id(clienteId);
    }
}
