package com.denis.api.lnf.model.partida.gol;

import java.util.UUID;

public record GolListaResponseDTO(UUID id, int minuto, String nomeAtleta, String nomeTime) {
}
