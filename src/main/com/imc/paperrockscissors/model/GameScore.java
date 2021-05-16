package com.imc.paperrockscissors.model;

import java.util.concurrent.atomic.AtomicInteger;

public class GameScore {

    private final AtomicInteger gameCount;
    private final AtomicInteger player1WinCount;
    private final AtomicInteger player2WinCount;

    public GameScore() {
        this.gameCount = new AtomicInteger(0);
        this.player1WinCount = new AtomicInteger(0);
        this.player2WinCount = new AtomicInteger(0);
    }

    public int getGameCount() {
        return gameCount.intValue();
    }

    public int getPlayer1WinCount() {
        return player1WinCount.intValue();
    }

    public int getPlayer2WinCount() {
        return player2WinCount.intValue();
    }

    public int getDrawGameCount() {
        return getGameCount() - (getPlayer1WinCount() + getPlayer2WinCount());
    }

    public void incrementGameCount(){
        gameCount.incrementAndGet();
    }

    public void incrementPlayerWinCount(){
        player1WinCount.incrementAndGet();
    }

    public void incrementPlayerLoseCount(){
        player2WinCount.incrementAndGet();
    }

}
