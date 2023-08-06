package com.example.darts.services;

import com.example.darts.models.Dartsman;
import com.example.darts.repositories.DartsmanRepository;
import com.example.darts.security.DartsmanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DartsmanDetailsService implements UserDetailsService {

    private final DartsmanRepository dartsmanRepository;

    @Autowired
    public DartsmanDetailsService(DartsmanRepository dartsmanRepository) {
        this.dartsmanRepository = dartsmanRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Dartsman> person = dartsmanRepository.findByUsername(username);

        if(person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new DartsmanDetails(person.get());
    }
}
