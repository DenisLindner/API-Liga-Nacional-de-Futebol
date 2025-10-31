package com.denis.api.lnf.exception;

import java.util.UUID;

public class TimeNaoExisteException extends RuntimeException {
    public TimeNaoExisteException(UUID id) {
        super("O Time com o id '"+id+"' não existe!");
    }
}
