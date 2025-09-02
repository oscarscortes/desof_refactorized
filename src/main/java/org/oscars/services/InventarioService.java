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

    @Transactional(readOnly = true)
    public List<Inventario> findBySucursalAndProveedor(Long sucursalId, Long proveedorId) {
        return this.inventarioRepository.findAllBySucursal_IdAndProducto_Proveedor_IdAndEstatus(sucursalId, proveedorId, 1);
    }

    @Transactional(readOnly = true)
    public List<Inventario> findTopSellBySucursal(Long sucursalId) {
        return this.inventarioRepository.findTopSellBySucursal_Id(sucursalId);
    }

    @Transactional(readOnly = true)
    public Inventario findByProductoAndSucursal(Long codigo, Long sucursalId) {
        return this.inventarioRepository.findAllByProducto_CodigoAndSucursal_Id(codigo, sucursalId);
    }

    @Transactional(readOnly = true)
    public List<Inventario> recomendedItems(String color, String modelo, Long sucursalId) {
        return this.inventarioRepository.recomendedItems(color, modelo, sucursalId);
    }

}
