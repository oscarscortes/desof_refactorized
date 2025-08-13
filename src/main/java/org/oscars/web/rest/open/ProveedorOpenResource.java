package org.oscars.web.rest.open;

import org.oscars.models.desof.domain.Proveedor;
import org.oscars.services.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open/proveedor")
public class ProveedorOpenResource {

    private final ProveedorService proveedorService;

    public ProveedorOpenResource(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping()
    public ResponseEntity<List<Proveedor>> findAll() {
        List<Proveedor> proveedores = this.proveedorService.findAll();
        return ResponseEntity.ok(proveedores);
    }
}
