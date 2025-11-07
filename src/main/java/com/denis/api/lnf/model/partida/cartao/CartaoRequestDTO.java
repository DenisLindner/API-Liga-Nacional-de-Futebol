package com.denis.api.lnf.model.partida.cartao;

import com.denis.api.lnf.model.enums.TipoCartao;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CartaoRequestDTO(@NotNull int minuto, @NotNull TipoCartao tipoCartao, @NotNull UUID idAtleta, @NotNull UUID idPartida) {
}
