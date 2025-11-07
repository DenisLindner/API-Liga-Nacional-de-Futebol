package com.denis.api.lnf.model.partida.cartao;

import com.denis.api.lnf.model.atleta.Atleta;
import com.denis.api.lnf.model.enums.TipoCartao;
import com.denis.api.lnf.model.partida.Partida;

import java.util.UUID;

public record CartaoResponseDTO(UUID id, int minuto, TipoCartao tipoCartao, Atleta atleta, Partida partida) {
}
