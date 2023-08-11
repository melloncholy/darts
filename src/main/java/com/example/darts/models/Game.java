package com.example.darts.models;

import com.example.darts.enums.GameStatus;
import com.example.darts.enums.GameType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "time_start")
    private LocalDateTime timeStart;
    @Column(name = "time_end")
    private LocalDateTime timeEnd;
    @Enumerated(EnumType.STRING)
    @Column(name = "game_type")
    private GameType gameType;
    @ManyToOne
    @JoinColumn(name = "first_dartsman_id", referencedColumnName = "id")
    private Dartsman firstDartsman;
    @ManyToOne
    @JoinColumn(name = "second_dartsman_id", referencedColumnName = "id")
    private Dartsman secondDartsman;
    @Column(name = "first_dartsman_score")
    private int firstDartsmanScore;
    @Column(name = "second_dartsman_score")
    private int secondDartsmanScore;
    @ManyToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "id")
    private Dartsman winner;
    @Column(name = "checkouts_amount")
    private int checkoutsAmount;
    @Column(name = "first_max_checkout")
    private int firstMaxCheckout;
    @Column(name = "second_max_checkout")
    private int secondMaxCheckout;
    @Column(name = "first_avg_checkout")
    private float firstAvgCheckout;
    @Column(name = "second_avg_checkout")
    private float secondAvgCheckout;
    @Column(name = "first_darts_amount")
    private int firstDartsAmount;
    @Column(name = "second_darts_amount")
    private int secondDartsAmount;
    @Column(name = "first_accuracy")
    private float firstAccuracy;
    @Column(name = "second_accuracy")
    private float secondAccuracy;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private GameStatus status;

    public Game() {
    }

    public Game(GameType gameType, GameStatus status) {
        this.gameType = gameType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Dartsman getFirstDartsman() {
        return firstDartsman;
    }

    public void setFirstDartsman(Dartsman firstDartsman) {
        this.firstDartsman = firstDartsman;
    }

    public Dartsman getSecondDartsman() {
        return secondDartsman;
    }

    public void setSecondDartsman(Dartsman secondDartsman) {
        this.secondDartsman = secondDartsman;
    }

    public int getFirstDartsmanScore() {
        return firstDartsmanScore;
    }

    public void setFirstDartsmanScore(int firstDartsmanScore) {
        this.firstDartsmanScore = firstDartsmanScore;
    }

    public int getSecondDartsmanScore() {
        return secondDartsmanScore;
    }

    public void setSecondDartsmanScore(int secondDartsmanScore) {
        this.secondDartsmanScore = secondDartsmanScore;
    }

    public Dartsman getWinner() {
        return winner;
    }

    public void setWinner(Dartsman winner) {
        this.winner = winner;
    }

    public int getCheckoutsAmount() {
        return checkoutsAmount;
    }

    public void setCheckoutsAmount(int checkoutsAmount) {
        this.checkoutsAmount = checkoutsAmount;
    }

    public int getFirstMaxCheckout() {
        return firstMaxCheckout;
    }

    public void setFirstMaxCheckout(int firstMaxCheckout) {
        this.firstMaxCheckout = firstMaxCheckout;
    }

    public int getSecondMaxCheckout() {
        return secondMaxCheckout;
    }

    public void setSecondMaxCheckout(int secondMaxCheckout) {
        this.secondMaxCheckout = secondMaxCheckout;
    }

    public float getFirstAvgCheckout() {
        return firstAvgCheckout;
    }

    public void setFirstAvgCheckout(float firstAvgCheckout) {
        this.firstAvgCheckout = firstAvgCheckout;
    }

    public float getSecondAvgCheckout() {
        return secondAvgCheckout;
    }

    public void setSecondAvgCheckout(float secondAvgCheckout) {
        this.secondAvgCheckout = secondAvgCheckout;
    }

    public int getFirstDartsAmount() {
        return firstDartsAmount;
    }

    public void setFirstDartsAmount(int firstDartsAmount) {
        this.firstDartsAmount = firstDartsAmount;
    }

    public int getSecondDartsAmount() {
        return secondDartsAmount;
    }

    public void setSecondDartsAmount(int secondDartsAmount) {
        this.secondDartsAmount = secondDartsAmount;
    }

    public float getFirstAccuracy() {
        return firstAccuracy;
    }

    public void setFirstAccuracy(float firstAccuracy) {
        this.firstAccuracy = firstAccuracy;
    }

    public float getSecondAccuracy() {
        return secondAccuracy;
    }

    public void setSecondAccuracy(float secondAccuracy) {
        this.secondAccuracy = secondAccuracy;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
