package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.time.Time;

import java.time.LocalDateTime;
import java.util.UUID;

public record PartidaResponseDTO(UUID id, LocalDateTime dataHorario, String estadio, int rodada, String nomeTimeMandante, String nomeTimeVisitante, String golsMandante, String golsVisitante, String temporada) {
}
