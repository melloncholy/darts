package com.example.darts.controllers;

import com.example.darts.dto.GameDTO;
import com.example.darts.errors.DartsErrorResponse;
import com.example.darts.errors.GameNotFoundException;
import com.example.darts.errors.WrongDartsmanException;
import com.example.darts.models.Dartsman;
import com.example.darts.models.Game;
import com.example.darts.services.DartsmanService;
import com.example.darts.services.GameService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final ModelMapper modelMapper;
    private final DartsmanService dartsmanService;

    @Autowired
    public GameController(GameService gameService, ModelMapper modelMapper, DartsmanService dartsmanService) {
        this.gameService = gameService;
        this.modelMapper = modelMapper;
        this.dartsmanService = dartsmanService;
    }

    @GetMapping
    public List<GameDTO> getGames() {
        return gameService.findAll().stream().map(this::convertToGameDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GameDTO getGame(@PathVariable("id") int id) {
        Game game = gameService.findOne(id);

        return convertToGameDTO(game);
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid GameDTO gameDTO) {

        Game game = convertToGame(gameDTO);
        game.setFirstDartsman(dartsmanService.getCurrentDartsman());

        gameService.save(game);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/apply/{id}")
    public ResponseEntity<HttpStatus> apply(@PathVariable("id") int id) {
        Game game = gameService.findOne(id);
        Dartsman secondDartsman = dartsmanService.getCurrentDartsman();

        if (game.getFirstDartsman().getId() != secondDartsman.getId()
                && game.getSecondDartsman() == null) {
            game.setSecondDartsman(secondDartsman);
            game.setTimeStart(LocalDateTime.now());

            gameService.save(game);
        } else {
            throw new WrongDartsmanException();
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<DartsErrorResponse> handleException(GameNotFoundException e) {
        DartsErrorResponse response = new DartsErrorResponse(
                "Game with this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<DartsErrorResponse> handleException(WrongDartsmanException e) {
        DartsErrorResponse response = new DartsErrorResponse(
                "Wrong Dartsman",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    private Game convertToGame(GameDTO gameDTO) {
        return modelMapper.map(gameDTO, Game.class);
    }


    private GameDTO convertToGameDTO(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}
