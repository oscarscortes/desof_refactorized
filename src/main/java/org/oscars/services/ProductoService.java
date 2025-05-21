package org.oscars.services;

import org.oscars.models.desof.domain.Producto;
import org.oscars.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto findByCodigo(Long codigo) {
        return this.productoRepository.findById(codigo).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Producto> findByProveedor(Long proveedorId) {
        return this.productoRepository.findAllByProveedor_Id(proveedorId);
    }

}
