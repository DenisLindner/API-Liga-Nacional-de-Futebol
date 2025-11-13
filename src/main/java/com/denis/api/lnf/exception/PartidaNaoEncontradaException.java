package com.denis.api.lnf.exception;

import java.util.UUID;

public class PartidaNaoEncontradaException extends RuntimeException {
    public PartidaNaoEncontradaException(UUID id) {
        super("A partida do id '"+id+"' não foi encontrada");
    }
}
