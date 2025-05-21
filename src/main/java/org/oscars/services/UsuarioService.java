package org.oscars.services;

import org.oscars.models.desof.domain.Usuario;
import org.oscars.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
}
