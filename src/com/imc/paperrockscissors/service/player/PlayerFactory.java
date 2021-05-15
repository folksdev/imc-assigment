package com.imc.paperrockscissors.service.player;

public class PlayerFactory {

    public static Player getPlayer(PlayerType playerType){
        return playerType.getInstance();
    }
}
