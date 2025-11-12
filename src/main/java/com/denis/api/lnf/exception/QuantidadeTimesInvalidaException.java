package com.denis.api.lnf.exception;

public class QuantidadeTimesInvalidaException extends RuntimeException {
    public QuantidadeTimesInvalidaException() {
        super("A quantidade de Times cadastrados em cada divisão é inválido");
    }
}
