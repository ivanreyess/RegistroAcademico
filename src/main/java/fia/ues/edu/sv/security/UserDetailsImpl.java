package fia.ues.edu.sv.security;

import fia.ues.edu.sv.domain.Rol;
import fia.ues.edu.sv.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 11-13-16.
 */
public class UserDetailsImpl implements UserDetails {

    private Usuario usuario;

    public UserDetailsImpl(Usuario usuario){
        this.usuario=usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
       /* Set<Rol> roles = (Set<Rol>) usuario.getRol();
        for (Rol rol: roles){
            authorities.add(new SimpleGrantedAuthority(rol.getNombrerol()));
        }*/
        Rol rol = usuario.getRol();
        System.out.println(usuario.getUsuario());
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombrerol()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.getContrasenia();
    }

    @Override
    public String getUsername() {
        return usuario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
