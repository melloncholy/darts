package com.example.darts.dto;

import com.example.darts.enums.GameStatus;
import com.example.darts.enums.GameType;
import com.example.darts.models.Dartsman;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class GameDTO {
    @Id
    private int id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    @Enumerated(EnumType.STRING)
    private GameType gameType;
    private DartsmanViewDTO firstDartsman;
    private DartsmanViewDTO secondDartsman;
    private int firstDartsmanScore;
    private int secondDartsmanScore;
    private DartsmanViewDTO winner;
    private int checkoutsAmount;
    private int firstMaxCheckout;
    private int secondMaxCheckout;
    private float firstAvgCheckout;
    private float secondAvgCheckout;
    private int firstDartsAmount;
    private int secondDartsAmount;
    private float firstAccuracy;
    private float secondAccuracy;
    @Enumerated(EnumType.STRING)
    private GameStatus status;

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

    public DartsmanViewDTO getFirstDartsman() {
        return firstDartsman;
    }

    public void setFirstDartsman(DartsmanViewDTO firstDartsman) {
        this.firstDartsman = firstDartsman;
    }

    public DartsmanViewDTO getSecondDartsman() {
        return secondDartsman;
    }

    public void setSecondDartsman(DartsmanViewDTO secondDartsman) {
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

    public DartsmanViewDTO getWinner() {
        return winner;
    }

    public void setWinner(DartsmanViewDTO winner) {
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
