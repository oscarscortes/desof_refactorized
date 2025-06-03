package org.oscars.repositories;

import org.oscars.models.desof.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByCorreoAndPassword(String correo, String password);

    List<Usuario> findAllByTipoUsuario(Integer tipoUsuario);

    boolean existsByUsername(String username);
}
