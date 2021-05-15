package com.imc.paperrockscissors.service;

import com.imc.paperrockscissors.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.imc.paperrockscissors.model.Symbol.*;
import static org.junit.jupiter.api.Assertions.*;

class GameResultServiceTest {

    private GameResultService service;

    @BeforeEach
    public void setup() {
        service = new GameResultService();
    }

    @Test
    public void testGetResult_whenPlayerIsRockAndComputerIsScissors_itShouldReturnPLAYER1_WIN() {
        int result = service.getResult(ROCK, SCISSORS);

        assertResults(result, Constants.PLAYER1_WIN, 1,1,0,0);
    }

    @Test
    public void testGetResult_whenPlayerIsScissorsAndComputerIsPaper_itShouldReturnPLAYER1_WIN() {
        int result = service.getResult(SCISSORS, PAPER);

        assertResults(result, Constants.PLAYER1_WIN, 1,1,0,0);
    }

    @Test
    public void testGetResult_whenPlayerIsPaperAndComputerIsRock_itShouldReturnPLAYER1_WIN() {
        int result = service.getResult(PAPER, ROCK);

        assertResults(result, Constants.PLAYER1_WIN, 1,1,0,0);
    }

    @Test
    public void testGetResult_whenPlayerAndComputerAreEquals_itShouldReturnDRAW() {
        int result = service.getResult(PAPER, PAPER);

        assertResults(result, Constants.DRAW, 1,0,1,0);
    }

    @Test
    public void testGetResult_whenPlayerIsRockAndComputerIsPaper_itShouldReturnPLAYER2_WIN() {
        int result = service.getResult(ROCK, PAPER);

        assertResults(result, Constants.PLAYER2_WIN, 1,0,0,1);
    }

    @Test
    public void testGetResult_whenPlayerIsPaperAndComputerIsScissors_itShouldReturnPLAYER2_WIN() {
        int result = service.getResult(PAPER, SCISSORS);

        assertResults(result, Constants.PLAYER2_WIN, 1,0,0,1);
    }

    @Test
    public void testGetResult_whenPlayerIsScissorsAndComputerIsRock_itShouldReturnPLAYER2_WIN() {
        int result = service.getResult(SCISSORS, ROCK);

        assertResults(result, Constants.PLAYER2_WIN, 1,0,0,1);
    }

    @Test
    public void testGetResult_whenMultipleGamePlayed_itShouldCalculateGameScores() {
        service.getResult(SCISSORS, ROCK);
        service.getResult(PAPER, SCISSORS);
        service.getResult(ROCK, PAPER);

        service.getResult(PAPER, PAPER);

        service.getResult(PAPER, ROCK);
        service.getResult(SCISSORS, PAPER);
        int result = service.getResult(ROCK, SCISSORS);

        assertResults(result, Constants.PLAYER1_WIN, 7,3,1,3);
    }

    @Test
    public void testIsFirstGame_whenGameCountIsZero_itShouldReturnTrue(){
        assertTrue(service.isFirstGame());
    }

    @Test
    public void testIsFirstGame_whenGameCountIsMoreThanZero_itShouldReturnFalse(){
        service.getResult(SCISSORS, ROCK);
        service.getResult(PAPER, SCISSORS);
        assertFalse(service.isFirstGame());
    }

    private void assertResults(int result,
                               int winner,
                               int gameCount,
                               int player1Win,
                               int draw,
                               int player2Win){
        assertAll(
                () -> assertEquals(result, winner),
                () -> assertEquals(service.getGameScore().getGameCount(), gameCount),
                () -> assertEquals(service.getGameScore().getPlayer1WinCount(), player1Win),
                () -> assertEquals(service.getGameScore().getDrawGameCount(), draw),
                () -> assertEquals(service.getGameScore().getPlayer2WinCount(), player2Win)
        );
    }


}