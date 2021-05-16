package com.imc.paperrockscissors.service.player;

import com.imc.paperrockscissors.model.Symbol;

import java.util.Random;

public class ComputerPlayer implements Player {

    private static final ComputerPlayer instance = new ComputerPlayer();

    private final Random random = new Random();

    private ComputerPlayer() {
    }

    public static ComputerPlayer getInstance() {
        return instance;
    }

    @Override
    public Symbol play() {
        return getSymbol(random.nextInt(Symbol.values().length));
    }
}
