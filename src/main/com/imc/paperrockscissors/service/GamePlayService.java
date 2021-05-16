package com.imc.paperrockscissors.service;

import com.imc.paperrockscissors.exception.BadMoveRequestException;
import com.imc.paperrockscissors.model.GameScore;
import com.imc.paperrockscissors.model.Symbol;
import com.imc.paperrockscissors.service.player.*;

import java.util.Scanner;
import java.util.logging.Logger;

import static com.imc.paperrockscissors.Constants.*;

public class GamePlayService {

    private static final Logger logger = Logger.getLogger(GamePlayService.class.getName());

    private final GameResultService gameResultService;
    private final Player humanPlayer;
    private final Player randomPlayer;
    private final Scanner scanner;

    public GamePlayService() {
        this.scanner = new Scanner(System.in);
        this.gameResultService = new GameResultService();
        this.humanPlayer = PlayerFactory.getPlayer(PlayerType.HUMAN);
        this.randomPlayer = PlayerFactory.getPlayer(PlayerType.COMPUTER);
    }

    public void start() {
        while (getAnotherPlay()) {
            System.out.print(INITIAL_STR);
            try {
                Symbol playerSymbol = humanPlayer.play();
                Symbol randomSymbol = randomPlayer.play();

                System.out.println("Player " + playerSymbol + " vs. Computer " + randomSymbol);

                int result = gameResultService.getResult(playerSymbol, randomSymbol);
                printResult(result);
            } catch (BadMoveRequestException e) {
                logger.warning(e.getMessage());
            }
        }
    }

    private boolean getAnotherPlay() {
        if (gameResultService.isFirstGame()) {
            return true;
        }
        printScore();
        System.out.print(ANOTHER_GAME_STR);
        try {
            if (Integer.parseInt(scanner.next()) == ANOTHER_GAME) {
                return true;
            }
        } catch (NumberFormatException e) {
            logger.warning(e.getMessage());
            return getAnotherPlay();
        }

        return false;
    }

    private void printScore() {
        GameScore score = gameResultService.getGameScore();
        System.out.printf(SCORE,
                score.getGameCount(),
                score.getPlayer1WinCount(),
                score.getPlayer2WinCount(),
                score.getDrawGameCount());
    }

    private void printResult(int result) {
        if (result == DRAW) {
            System.out.println(DRAW_RESULT);
        } else if (result == PLAYER1_WIN) {
            System.out.println(PLAYER_WIN_RESULT);
        } else if (result == PLAYER2_WIN) {
            System.out.println(PLAYER_LOSE_RESULT);
        }
    }

}
