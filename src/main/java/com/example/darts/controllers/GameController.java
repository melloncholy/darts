package com.example.darts.controllers;

import com.example.darts.errors.DartsErrorResponse;
import com.example.darts.errors.DartsmanNotFoundException;
import com.example.darts.errors.GameNotFoundException;
import com.example.darts.models.Game;
import com.example.darts.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") int id) {
        return gameService.findOne(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Game game) {

        game.setTimeStart(LocalDateTime.now());
        gameService.save(game);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @ExceptionHandler
    private ResponseEntity<DartsErrorResponse> handleException(GameNotFoundException e) {
        DartsErrorResponse response = new DartsErrorResponse(
                "Game with this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
