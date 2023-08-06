package com.example.darts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dartsman")
public class Dartsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Username can`t be empty")
    @Size(min = 3, max = 20, message = "Username must be from 3 to 20 symbols")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Password can`t be empty")
    @Size(min = 4, max = 15, message = "Password must be from 4 to 20 symbols")
    @Column(name = "password")
    private String password;
    @Email
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "dartsman")
    private Image image;

    public Dartsman() {
    }

    public Dartsman(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
