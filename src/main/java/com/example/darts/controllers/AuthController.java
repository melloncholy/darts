package com.example.darts.controllers;

import com.example.darts.dto.AuthenticationDTO;
import com.example.darts.dto.DartsmanDTO;
import com.example.darts.models.Dartsman;
import com.example.darts.security.JWTUtil;
import com.example.darts.services.RegistrationService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;

    public AuthController(RegistrationService registrationService, JWTUtil jwtUtil,
                          ModelMapper modelMapper, AuthenticationManager authenticationManager) {
        this.registrationService = registrationService;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@RequestBody @Valid DartsmanDTO dartsmanDTO,
                               BindingResult bindingResult) {

        Dartsman dartsman = convertToDartsman(dartsmanDTO);

        if (bindingResult.hasErrors())
            return Map.of("message", "Error reg");

        registrationService.register(dartsman);

        String token = jwtUtil.generateToken(dartsman.getUsername());

        return Map.of("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            return Map.of("message", "Incorrect credentials");
        }

        String token = jwtUtil.generateToken(authenticationDTO.getUsername());
        System.out.println(token);
        return Map.of("jwt-token", token);
    }

    public Dartsman convertToDartsman(DartsmanDTO dartsmanDTO) {
        return this.modelMapper.map(dartsmanDTO, Dartsman.class);
    }
}
