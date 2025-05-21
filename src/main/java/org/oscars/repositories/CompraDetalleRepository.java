package org.oscars.repositories;

import org.oscars.models.desof.domain.CompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraDetalleRepository extends JpaRepository<CompraDetalle, Long> {
    List<CompraDetalle> findAllByCompra_Id(Long compraId);

    List<CompraDetalle> findAllByInventario_Id(Long inventarioId);
}
