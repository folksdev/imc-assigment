package com.imc.paperrockscissors.service;

import com.imc.paperrockscissors.Constants;
import com.imc.paperrockscissors.model.GameScore;
import com.imc.paperrockscissors.model.Symbol;

import static com.imc.paperrockscissors.Constants.FIRST_GAME;
import static com.imc.paperrockscissors.model.Symbol.*;

public class GameResultService {

    private final GameScore gameScore;

    public GameResultService() {
        this.gameScore = new GameScore();
    }

    public int getResult(Symbol playerSymbol, Symbol randomSymbol) {
        int result;

        if (playerSymbol.equals(randomSymbol)) {
            result = Constants.DRAW;
        } else if (checkWinner(playerSymbol, randomSymbol)) {
            gameScore.incrementPlayerWinCount();
            result = Constants.PLAYER1_WIN;
        } else {
            gameScore.incrementPlayerLoseCount();
            result = Constants.PLAYER2_WIN;
        }
        gameScore.incrementGameCount();

        return result;
    }

    private boolean checkWinner(Symbol firstSymbol, Symbol secondSymbol) {
        return (ROCK.equals(firstSymbol) && SCISSORS.equals(secondSymbol)) ||
                (SCISSORS.equals(firstSymbol) && PAPER.equals(secondSymbol)) ||
                (PAPER.equals(firstSymbol) && ROCK.equals(secondSymbol));
    }

    public GameScore getGameScore() {
        return this.gameScore;
    }

    public boolean isFirstGame() {
        return gameScore.getGameCount() == FIRST_GAME;
    }
}
