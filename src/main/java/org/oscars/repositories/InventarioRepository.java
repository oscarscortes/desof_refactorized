package org.oscars.repositories;

import org.oscars.models.desof.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findAllBySucursal_Id(Long sucursalId);

    List<Inventario> findAllByProducto_Codigo(Long productoCodigo);
}
