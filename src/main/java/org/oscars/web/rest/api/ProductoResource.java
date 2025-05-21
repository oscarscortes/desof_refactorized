package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Producto;
import org.oscars.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoResource {

    private final ProductoService productoService;

    public ProductoResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping()
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(this.productoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Producto> findById(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok(this.productoService.findByCodigo(codigo));
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<Producto>> findByProveedorId(@PathVariable("proveedorId") Long proveedorId) {
        return ResponseEntity.ok(this.productoService.findByProveedor(proveedorId));
    }
}
