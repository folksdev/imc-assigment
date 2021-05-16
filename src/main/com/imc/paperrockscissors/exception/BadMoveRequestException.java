package com.imc.paperrockscissors.exception;

public class BadMoveRequestException extends RuntimeException{

    public BadMoveRequestException(String message) {
        super(message);
    }
}
