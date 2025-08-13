package org.oscars.web.rest.open;

import org.oscars.models.desof.domain.Sucursal;
import org.oscars.services.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open/sucursal")
public class SucursalOpenResource {

    private final SucursalService sucursalService;

    public SucursalOpenResource(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping()
    public ResponseEntity<List<Sucursal>> findAll() {
        return ResponseEntity.ok(this.sucursalService.findAll());
    }
}
