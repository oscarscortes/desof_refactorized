package org.oscars.web.rest.api;

import org.oscars.models.desof.domain.Usuario;
import org.oscars.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(this.usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.usuarioService.findById(id));
    }

    @GetMapping("/usuario-password/{username}/{password}")
    public ResponseEntity<Usuario> findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password) {
        return ResponseEntity.ok(this.usuarioService.findByUsernameAndPassword(username, password));
    }

    @GetMapping("/correo-password/{correo}/{password}")
    public ResponseEntity<Usuario> findByCorreoAndPassword(@PathVariable("correo") String correo, @PathVariable("password") String password) {
        return ResponseEntity.ok(this.usuarioService.findByCorreoAndPassword(correo, password));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Usuario>> findByTipo(@PathVariable("tipo") Integer tipo) {
        return ResponseEntity.ok(this.usuarioService.findByTipoUsuario(tipo));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> findByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(this.usuarioService.findByUsername(username));
    }

}
