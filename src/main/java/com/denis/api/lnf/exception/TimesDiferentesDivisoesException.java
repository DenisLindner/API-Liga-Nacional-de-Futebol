package com.denis.api.lnf.exception;

public class TimesDiferentesDivisoesException extends RuntimeException {
    public TimesDiferentesDivisoesException(String timeMandante, String timeVisitante) {
        super("Os times '"+timeMandante+"' e '"+timeVisitante+"', são de divisões diferentes!");
    }
}
