package com.denis.api.lnf.exception;

import java.util.UUID;

public class TemporadaNaoExisteException extends RuntimeException {
    public TemporadaNaoExisteException(UUID id) {
        super("A Temporada com o id '"+id+"' não existe!");
    }
}
