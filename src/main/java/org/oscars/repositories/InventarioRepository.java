package org.oscars.repositories;

import org.oscars.models.desof.domain.Inventario;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findAllBySucursal_Id(Long sucursalId);

    List<Inventario> findAllByProducto_Codigo(Long productoCodigo);

    List<Inventario> findAllBySucursal_IdAndProducto_Proveedor_IdAndEstatus(Long sucursalId, Long productoProveedorId, Integer estatus);

    @Query("SELECT i FROM Producto  p INNER JOIN Inventario i ON p.codigo = i.producto.codigo INNER JOIN Sucursal s ON i.sucursal.id = s.id INNER JOIN CompraDetalle cd ON cd.inventario.id = i.id WHERE s.id = :sucursalId AND i.estatus = 1 GROUP BY i.id ORDER BY SUM(cd.cantidad) DESC FETCH FIRST 6 ROWS ONLY")
    List<Inventario> findTopSellBySucursal_Id(Long sucursalId);

    Inventario findAllByProducto_CodigoAndSucursal_Id(Long productoCodigo, Long sucursalId);

    @Query("SELECT i FROM Inventario i INNER JOIN Sucursal s ON i.sucursal.id = s.id INNER JOIN Producto p ON i.producto.codigo = p.codigo WHERE i.estatus = 1 AND s.id = :sucursalId AND (p.color = :color OR p.modelo = :modelo)")
    List<Inventario> recomendedItems(String color, String modelo, Long sucursalId);
}
