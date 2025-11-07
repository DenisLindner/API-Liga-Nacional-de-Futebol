package com.denis.api.lnf.model.atleta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record AtletaRequestDTO(@NotBlank @Size(min = 3) String nome, @NotNull LocalDate dataInicioContrato, @NotNull LocalDate dataFimContrato, @NotNull UUID idTime) {
}
