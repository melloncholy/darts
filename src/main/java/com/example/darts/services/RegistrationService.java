package com.example.darts.services;

import com.example.darts.models.Dartsman;
import com.example.darts.repositories.DartsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final DartsmanRepository dartsmanRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(DartsmanRepository dartsmanRepository, PasswordEncoder passwordEncoder) {
        this.dartsmanRepository = dartsmanRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Dartsman dartsman) {
        dartsman.setPassword(passwordEncoder.encode(dartsman.getPassword()));

        dartsmanRepository.save(dartsman);
    }
}
