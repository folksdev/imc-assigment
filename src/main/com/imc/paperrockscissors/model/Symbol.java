package com.imc.paperrockscissors.model;

import com.imc.paperrockscissors.exception.BadMoveRequestException;

import java.util.Arrays;

public enum Symbol {

    PAPER(0), ROCK(1), SCISSORS(2);

    private final int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Symbol getByValue(int value){
        return Arrays.stream(Symbol.values())
                .filter(i -> i.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new BadMoveRequestException(value + " is not eligible choice. Try again!"));
    }
}
