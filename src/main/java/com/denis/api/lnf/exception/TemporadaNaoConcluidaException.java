package com.denis.api.lnf.exception;

import com.denis.api.lnf.model.enums.Divisao;

public class TemporadaNaoConcluidaException extends RuntimeException {
    public TemporadaNaoConcluidaException() {
        super("Ainda existe temporada(s) que não foram concluidas");
    }
}
