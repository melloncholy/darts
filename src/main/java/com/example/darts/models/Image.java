package com.example.darts.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(schema = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "dartsman_id")
    private Dartsman dartsman;
}
