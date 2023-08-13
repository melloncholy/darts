package com.example.darts.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DartsmanViewDTO {
    @Id
    private int id;
    @NotEmpty(message = "Username can`t be empty")
    @Size(min = 3, max = 20, message = "Username must be from 3 to 20 symbols")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
