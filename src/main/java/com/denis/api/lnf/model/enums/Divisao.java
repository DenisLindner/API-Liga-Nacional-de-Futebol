package com.denis.api.lnf.model.enums;

import lombok.Getter;

@Getter
public enum Divisao {
    A("a"),
    B("b");

    private String divisao;

    Divisao(String divisao) {
        this.divisao = divisao;
    }
}
