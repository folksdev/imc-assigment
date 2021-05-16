package com.imc.paperrockscissors.model;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GameScoreTest {

    private final GameScore gameScore = new GameScore();

    @Test
    public void testGetDrawGameCount(){
        IntStream.range(0, 10).forEach(i -> {
            gameScore.incrementGameCount();
            if(i % 2 == 0){
                gameScore.incrementPlayerWinCount();
            }
        });

        int drawCount = gameScore.getDrawGameCount();

        assertEquals(drawCount, 5);

    }

}