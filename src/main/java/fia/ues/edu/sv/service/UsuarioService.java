package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Usuario;
import fia.ues.edu.sv.repository.UsuarioRepository;
import fia.ues.edu.sv.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 11-13-16.
 */
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByusuario(userName);

        if(usuario==null){
            throw new UsernameNotFoundException(userName);
        }

        return new UserDetailsImpl(usuario);
    }
}
