package com.imc.paperrockscissors.service.player;

import com.imc.paperrockscissors.exception.BadMoveRequestException;
import com.imc.paperrockscissors.model.Symbol;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private static final HumanPlayer instance = new HumanPlayer();
    private final Scanner scanner;

    protected HumanPlayer(Scanner scanner){
        this.scanner = scanner;
    }

    private HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    public static HumanPlayer getInstance() {
        return instance;
    }

    @Override
    public Symbol play() {
        try {
            String symbolInput = scanner.next();
            return getSymbol(Integer.parseInt(symbolInput));
        } catch (NumberFormatException e) {
            throw new BadMoveRequestException(e.getMessage());
        }
    }
}
