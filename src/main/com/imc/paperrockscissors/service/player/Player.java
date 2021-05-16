package com.imc.paperrockscissors.service.player;

import com.imc.paperrockscissors.model.Symbol;

public interface Player {

    default Symbol getSymbol(int symbol) {
        return Symbol.getByValue(symbol);
    }

    Symbol play();

}
