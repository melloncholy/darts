package com.example.darts.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DartsmanDTO {
    @Id
    private int id;
    @NotEmpty(message = "Username can`t be empty")
    @Size(min = 3, max = 20, message = "Username must be from 3 to 20 symbols")
    private String username;
    @NotEmpty(message = "Password can`t be empty")
    private String password;
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
