package fia.ues.edu.sv.security;

import fia.ues.edu.sv.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by ivan on 11-13-16.
 */
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Usuario usuario;

    public UserDetails(Usuario usuario){
        this.usuario=usuario;  
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
