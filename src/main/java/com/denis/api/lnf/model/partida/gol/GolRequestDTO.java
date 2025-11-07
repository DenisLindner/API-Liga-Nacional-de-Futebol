package com.denis.api.lnf.model.partida.gol;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GolRequestDTO(@NotNull int minuto, @NotNull UUID idAtleta, @NotNull UUID idPartida) {
}
