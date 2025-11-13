package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.temporada.Temporada;
import com.denis.api.lnf.model.time.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PartidaRequestDTO(@NotNull LocalDateTime dataHorario, @NotBlank String estadio, @NotNull int rodada, @NotNull Time timeMandante, @NotNull Time timeVisitante, @NotNull
                                Temporada temporada) {
}
