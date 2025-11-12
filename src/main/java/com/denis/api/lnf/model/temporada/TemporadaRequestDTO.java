package com.denis.api.lnf.model.temporada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TemporadaRequestDTO(@NotBlank String patrocinadoraMaster, @NotNull LocalDate dataInicio) {
}
