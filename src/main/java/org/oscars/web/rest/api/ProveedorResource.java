package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Proveedor;
import org.oscars.services.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorResource {

    private final ProveedorService proveedorService;

    public ProveedorResource(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping()
    public ResponseEntity<List<Proveedor>> findAll() {
        return ResponseEntity.ok(this.proveedorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.proveedorService.findById(id));
    }
}
