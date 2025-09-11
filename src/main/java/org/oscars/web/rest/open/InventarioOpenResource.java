package org.oscars.web.rest.open;

import org.oscars.models.desof.domain.Inventario;
import org.oscars.services.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open/inventario")
public class InventarioOpenResource {

    private final InventarioService inventarioService;

    public InventarioOpenResource(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<Inventario>> findBySucursalId(@PathVariable Long sucursalId) {
        List<Inventario> inventarios = this.inventarioService.findBySucursal(sucursalId);
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/sucursal-proveedor/{sucursalId}/{proveedorId}")
    public ResponseEntity<List<Inventario>> findBySucursalAndProveedor(@PathVariable Long sucursalId, @PathVariable Long proveedorId) {
        List<Inventario> inventarios = this.inventarioService.findBySucursalAndProveedor(sucursalId, proveedorId);
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/top-sell-sucursal/{sucursalId}")
    public ResponseEntity<List<Inventario>> findTopSellBySucursal(@PathVariable Long sucursalId) {
        List<Inventario> inventarios = this.inventarioService.findTopSellBySucursal(sucursalId);
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/producto-sucursal/{codigo}/{sucursalId}")
    public ResponseEntity<Inventario> findByProducto(@PathVariable Long codigo, @PathVariable Long sucursalId) {
        Inventario inventarios = this.inventarioService.findByProductoAndSucursal(codigo, sucursalId);
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/recomended-items/{color}/{modelo}/{sucursalId}")
    public ResponseEntity<List<Inventario>> findRecomendedItems(@PathVariable String color, @PathVariable String modelo, @PathVariable Long sucursalId) {
        List<Inventario> inventarios = this.inventarioService.recomendedItems(color, modelo, sucursalId);
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/search/{term}/{sucursalId}")
    public ResponseEntity<List<Inventario>> searchInSucursal(@PathVariable("term") String term, @PathVariable("sucursalId") Long sucursalId) {
        List<Inventario> inventarios = this.inventarioService.search(sucursalId, term);
        return ResponseEntity.ok(inventarios);
    }
}
