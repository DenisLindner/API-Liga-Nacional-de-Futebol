package com.denis.api.lnf.model.enums;

import lombok.Getter;

@Getter
public enum TipoCartao {
    AMARELO("amarelo"),
    VERMELHO("vermelho");

    private String tipoCartao;

    TipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
