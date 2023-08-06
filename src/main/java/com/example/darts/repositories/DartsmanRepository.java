package com.example.darts.repositories;

import com.example.darts.models.Dartsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DartsmanRepository extends JpaRepository<Dartsman, Integer> {
    public Optional<Dartsman> findByUsername(String username);
}
