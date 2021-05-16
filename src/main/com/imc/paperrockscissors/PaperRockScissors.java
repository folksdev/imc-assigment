package com.imc.paperrockscissors;

import com.imc.paperrockscissors.service.GamePlayService;

public class PaperRockScissors {

    public static void main(String[] args) {
        GamePlayService gamePlayService = new GamePlayService();
        gamePlayService.start();
    }
}
