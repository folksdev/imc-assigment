package com.imc.paperrockscissors.service.player;

import com.imc.paperrockscissors.exception.BadMoveRequestException;
import com.imc.paperrockscissors.model.Symbol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    private HumanPlayer service;

    @Test
    public void testPlay_whenInputIsOne_shouldReturnRock() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        service = new HumanPlayer(new Scanner(in));

        Symbol result = service.play();
        System.setIn(sysInBackup);
        assertEquals(result, Symbol.ROCK);
    }

    @Test
    public void testPlay_whenInputIsOutOfRange_shouldThrowBadMoveRequestException() {

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);
        service = new HumanPlayer(new Scanner(in));
        Exception exception = assertThrows(BadMoveRequestException.class, () ->
                service.play()
        );
        System.setIn(sysInBackup);
        assertEquals(exception.getMessage(), 3 + " is not eligible choice. Try again!");
    }

    @Test
    public void testPlay_whenInputIsNotANumber_shouldReturnBadMoveRequestException() {

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("a\n".getBytes());
        System.setIn(in);
        service = new HumanPlayer(new Scanner(in));

        Exception exception = assertThrows(BadMoveRequestException.class, () ->
                service.play()
            );

        System.setIn(sysInBackup);

        assertEquals(exception.getMessage(), "For input string: \"a\"");

    }

}