package com.denis.api.lnf.model.partida.sumula;

import com.denis.api.lnf.model.partida.cartao.Cartao;
import com.denis.api.lnf.model.partida.gol.Gol;

import java.util.List;
import java.util.UUID;

public record SumulaRequestDTO(UUID idPartida, List<Gol> gols, List<Cartao> cartoes) {
}
