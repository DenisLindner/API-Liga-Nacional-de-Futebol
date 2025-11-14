package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.partida.cartao.CartaoListaResponseDTO;
import com.denis.api.lnf.model.partida.gol.GolListaResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PartidaDetalhadaResponseDTO(UUID id, LocalDateTime dataHorario, String estadio, int rodada, String nomeTimeMandante, String nomeTimeVisitante, String golsMandante, String golsVisitante, String temporada, List<GolListaResponseDTO> gols, List<CartaoListaResponseDTO> cartoes) {
}
