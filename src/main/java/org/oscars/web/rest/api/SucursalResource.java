package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Sucursal;
import org.oscars.services.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalResource {

    private final SucursalService sucursalService;

    public SucursalResource(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping()
    public ResponseEntity<List<Sucursal>> findAll() {
        return ResponseEntity.ok(this.sucursalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sucursalService.findById(id));
    }
}
