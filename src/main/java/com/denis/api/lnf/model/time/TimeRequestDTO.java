package com.denis.api.lnf.model.time;

import com.denis.api.lnf.model.enums.Divisao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TimeRequestDTO(@NotBlank @Size(min = 3) String nome, @NotNull LocalDate dataFundacao, @NotNull Divisao divisao, @NotBlank String urlLogo) {
}
