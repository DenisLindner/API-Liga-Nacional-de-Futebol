package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.time.Time;

import java.time.LocalDateTime;
import java.util.UUID;

public record PartidaResponseDTO(UUID id, LocalDateTime dataHorario, String estadio, int rodada, Time timeMandante, Time timeVisitante, String golsMandante, String golsVisitante, String temporada) {
}
