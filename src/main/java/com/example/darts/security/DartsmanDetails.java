package com.example.darts.security;

import com.example.darts.models.Dartsman;
import com.example.darts.repositories.DartsmanRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class DartsmanDetails implements UserDetails {
    private final Dartsman dartsman;

    public DartsmanDetails(Dartsman dartsman) {
        this.dartsman = dartsman;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.dartsman.getPassword();
    }

    @Override
    public String getUsername() {
        return this.dartsman.getUsername();
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

    public Dartsman getDartsman() {
        return dartsman;
    }
}
