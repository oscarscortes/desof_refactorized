package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Compra;
import org.oscars.services.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraResource {

    private final CompraService compraService;

    public CompraResource(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping()
    public ResponseEntity<List<Compra>> findAll() {
        return ResponseEntity.ok(this.compraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.compraService.findById(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Compra>> findByCliente(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.ok(this.compraService.findByClienteId(clienteId));
    }
}
