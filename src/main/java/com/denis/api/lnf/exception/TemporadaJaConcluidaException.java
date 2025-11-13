package com.denis.api.lnf.exception;

public class TemporadaJaConcluidaException extends RuntimeException {
    public TemporadaJaConcluidaException() {
        super("Temporada já finalizada");
    }
}
