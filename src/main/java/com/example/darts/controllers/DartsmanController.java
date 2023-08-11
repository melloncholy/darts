package com.example.darts.controllers;

import com.example.darts.dto.DartsmanDTO;
import com.example.darts.errors.DartsErrorResponse;
import com.example.darts.errors.DartsmanNotFoundException;
import com.example.darts.models.Dartsman;
import com.example.darts.security.DartsmanDetails;
import com.example.darts.services.DartsmanService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dartsmans")
public class DartsmanController {
    private final DartsmanService dartsmanService;
    private final ModelMapper modelMapper;

    @Autowired
    public DartsmanController(DartsmanService dartsmanService, ModelMapper modelMapper) {
        this.dartsmanService = dartsmanService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/showUser")
    public String showUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DartsmanDetails dartsmanDetails = (DartsmanDetails) authentication.getPrincipal();

        return dartsmanDetails.getUsername();
    }
    @GetMapping()
    public List<DartsmanDTO> getDartsmans() {
        return dartsmanService.findAll().stream().map(this::convertToDartsmanDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DartsmanDTO getDartsman(@PathVariable("id") int id) {
        Dartsman dartsman = dartsmanService.findOne(id);

        return convertToDartsmanDTO(dartsman);
    }

    private Dartsman convertToDartsman(DartsmanDTO dartsmanDTO) {
        return modelMapper.map(dartsmanDTO, Dartsman.class);
    }


    private DartsmanDTO convertToDartsmanDTO(Dartsman dartsman) {
        return modelMapper.map(dartsman, DartsmanDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<DartsErrorResponse> handleException(DartsmanNotFoundException e) {
        DartsErrorResponse response = new DartsErrorResponse(
                "Dartsman with this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
