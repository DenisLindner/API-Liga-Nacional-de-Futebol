package com.denis.api.lnf.model.temporada;

import com.denis.api.lnf.model.enums.Divisao;

import java.time.LocalDate;
import java.util.UUID;

public record TemporadaResponseDTO(UUID id, String nome, LocalDate dataInicio, Divisao divisao, boolean concluido) {
}
