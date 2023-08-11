package com.example.darts.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GameType {
    TYPE_301,
    TYPE_501
}
