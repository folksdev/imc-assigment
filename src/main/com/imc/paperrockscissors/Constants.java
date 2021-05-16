package com.imc.paperrockscissors;

public class Constants {

    public static final String LINE = "----------------------------------------------------";

    public static final String SCORE = LINE + "\n" +
            "Total played game: %d \n" +
            "Player win: %d " + "Player lose: %d " + "Draw games: %d \n" +
            LINE;

    public static final String INITIAL_STR = LINE + "\n" +
            "Paper Rock Scissors Game\n" +
            "Pick your symbol : 0 (Paper), 1 (Rock), 2 (Scissors) : ";

    public static final String DRAW_RESULT = "IT'S A DRAW!";
    public static final String PLAYER_WIN_RESULT = "Player win!";
    public static final String PLAYER_LOSE_RESULT = "Player lose!";
    public static final String ANOTHER_GAME_STR = "\nDo you want to play again? Y(1), N(0)? : ";

    public static final int DRAW = 0;
    public static final int PLAYER1_WIN = 1;
    public static final int PLAYER2_WIN = 2;

    public static final int ANOTHER_GAME = 1;
    public static final int FIRST_GAME = 0;
}
