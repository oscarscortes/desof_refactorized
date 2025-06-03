package org.oscars.services;

import org.oscars.dto.RegisterRequest;
import org.oscars.models.desof.domain.Usuario;
import org.oscars.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return this.usuarioRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findByUsernameAndPassword(String username, String password) {
        return this.usuarioRepository.findByUsernameAndPassword(username, password);
    }

    @Transactional(readOnly = true)
    public Usuario findByCorreoAndPassword(String correo, String password) {
        return this.usuarioRepository.findByCorreoAndPassword(correo, password);
    }

    @Transactional(readOnly = true)
    public List<Usuario> findByTipoUsuario(Integer tipoUsuario) {
        return this.usuarioRepository.findAllByTipoUsuario(tipoUsuario);
    }

    @Transactional()
    public Usuario create(RegisterRequest request) {
        if (this.usuarioRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Usuario u = new Usuario();
        u.setUsername(request.getUsername());
        u.setPassword(this.passwordEncoder.encode(request.getPassword()));
        u.setCorreo(request.getEmail());
        u.setTipoUsuario(1);

        return this.usuarioRepository.save(u);
    }
}
