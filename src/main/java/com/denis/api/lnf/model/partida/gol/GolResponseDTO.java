package com.denis.api.lnf.model.partida.gol;

import com.denis.api.lnf.model.partida.Partida;

import java.util.UUID;

public record GolResponseDTO(UUID id, int minuto, String nomeAtleta, String nomeTime, Partida partida) {
}
