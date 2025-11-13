package com.denis.api.lnf.exception;

import com.denis.api.lnf.model.enums.Divisao;

public class MaximoDeTimesDivisaoException extends RuntimeException {
    public MaximoDeTimesDivisaoException(Divisao divisao) {
        super("O número máximo de Times da divisão '"+divisao+"' foi atingido!");
    }
}
