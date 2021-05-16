package com.imc.paperrockscissors.service.player;

public enum PlayerType {
    HUMAN {
        @Override
        public HumanPlayer getInstance(){
            return HumanPlayer.getInstance();
        }
    },
    COMPUTER{
        @Override
        public ComputerPlayer getInstance(){
            return ComputerPlayer.getInstance();
        }
    };

    public abstract Player getInstance();
}
