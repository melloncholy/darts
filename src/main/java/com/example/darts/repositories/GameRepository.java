package com.example.darts.repositories;

import com.example.darts.models.Dartsman;
import com.example.darts.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    public List<Game> findGameByFirstDartsmanOrSecondDartsman(Dartsman firstDartsman, Dartsman secondDartsman);
}