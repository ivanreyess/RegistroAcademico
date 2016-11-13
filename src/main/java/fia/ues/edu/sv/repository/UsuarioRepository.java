package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivan on 11-13-16.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByusuario(String usuario);
}
