package org.oscars.services.jwt;

import org.oscars.models.desof.domain.Usuario;
import org.oscars.repositories.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceJWT implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceJWT(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new User(
                    usuario.getUsername(),
                    usuario.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(usuario.getTipoUsuario().toString()))
            );
        }
    }
}
