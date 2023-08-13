package com.example.darts.services;

import com.example.darts.enums.GameStatus;
import com.example.darts.enums.GameType;
import com.example.darts.errors.GameNotFoundException;
import com.example.darts.models.Dartsman;
import com.example.darts.models.Game;
import com.example.darts.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GameService {

    private final GameRepository gameRepository;
    private final DartsmanService dartsmanService;

    @Autowired
    public GameService(GameRepository gameRepository, DartsmanService dartsmanService) {
        this.gameRepository = gameRepository;
        this.dartsmanService = dartsmanService;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findOne(int id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow(GameNotFoundException::new);
    }

    public List<Game> findDartsmanGames(Dartsman dartsman) {
        return gameRepository.findGameByFirstDartsmanOrSecondDartsman(dartsman, dartsman);
    }

    @Transactional
    public void save(Game game) {
        gameRepository.save(game);
    }


}
