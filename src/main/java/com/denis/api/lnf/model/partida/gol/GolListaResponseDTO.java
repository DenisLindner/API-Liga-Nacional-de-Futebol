package com.denis.api.lnf.model.partida.gol;

import com.denis.api.lnf.model.atleta.Atleta;

import java.util.UUID;

public record GolListaResponseDTO(UUID id, int minuto, Atleta atleta) {
}
