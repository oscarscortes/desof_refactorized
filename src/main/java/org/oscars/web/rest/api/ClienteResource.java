package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Cliente;
import org.oscars.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.clienteService.findById(id));
    }

    @GetMapping("/estatus/{estatus}")
    public ResponseEntity<List<Cliente>> findByEstatus(@PathVariable("estatus") Integer estatus) {
        return ResponseEntity.ok(this.clienteService.findAllByEstatus(estatus));
    }
}
