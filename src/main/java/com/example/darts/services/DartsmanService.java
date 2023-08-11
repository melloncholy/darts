package com.example.darts.services;

import com.example.darts.errors.DartsmanNotFoundException;
import com.example.darts.models.Dartsman;
import com.example.darts.repositories.DartsmanRepository;
import com.example.darts.security.DartsmanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DartsmanService {
    private final DartsmanRepository dartsmanRepository;

    @Autowired
    public DartsmanService(DartsmanRepository dartsmanRepository) {
        this.dartsmanRepository = dartsmanRepository;
    }

    public Dartsman getCurrentDartsman() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DartsmanDetails dartsmanDetails = (DartsmanDetails) authentication.getPrincipal();

        return dartsmanDetails.getDartsman();
    }

    public List<Dartsman> findAll() {
        return dartsmanRepository.findAll();
    }

    public Dartsman findOne(int id) {
        Optional<Dartsman> dartsman = dartsmanRepository.findById(id);
        return dartsman.orElseThrow(DartsmanNotFoundException::new);
    }
}
