package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.CompraDetalle;
import org.oscars.services.CompraDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compra-detalle")
public class CompraDetalleResource {

    private final CompraDetalleService compraDetalleService;

    public CompraDetalleResource(CompraDetalleService compraDetalleService) {
        this.compraDetalleService = compraDetalleService;
    }

    @GetMapping()
    public ResponseEntity<List<CompraDetalle>> findAll() {
        return ResponseEntity.ok(this.compraDetalleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDetalle> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.compraDetalleService.findById(id));
    }

    @GetMapping("/inventario/{inventarioId}")
    public ResponseEntity<List<CompraDetalle>> findByInventarioId(@PathVariable("inventarioId") Long inventarioId) {
        return ResponseEntity.ok(this.compraDetalleService.findByInventarioId(inventarioId));
    }

    @GetMapping("/compra/{compraId}")
    public ResponseEntity<List<CompraDetalle>> findByCompraId(@PathVariable("compraId") Long compraId) {
        return ResponseEntity.ok(this.compraDetalleService.findByCompraId(compraId));
    }
}
