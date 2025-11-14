package com.denis.api.lnf.model.partida.cartao;

import com.denis.api.lnf.model.enums.TipoCartao;

import java.util.UUID;

public record CartaoListaResponseDTO(UUID id, int minuto, TipoCartao tipoCartao, String nomeAtleta, String nomeTime) {
}
