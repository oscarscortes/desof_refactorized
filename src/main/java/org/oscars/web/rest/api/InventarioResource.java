package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Inventario;
import org.oscars.services.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioResource {

    private final InventarioService inventarioService;

    public InventarioResource(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping()
    public ResponseEntity<List<Inventario>> findAll() {
        return ResponseEntity.ok(this.inventarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.inventarioService.findById(id));
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<Inventario>> findBySucursal(@PathVariable("sucursalId") Long sucursalId) {
        return ResponseEntity.ok(this.inventarioService.findBySucursal(sucursalId));
    }

    @GetMapping("/producto/{codigo}")
    public ResponseEntity<List<Inventario>> findByProducto(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok(this.inventarioService.findByProducto(codigo));
    }
}
