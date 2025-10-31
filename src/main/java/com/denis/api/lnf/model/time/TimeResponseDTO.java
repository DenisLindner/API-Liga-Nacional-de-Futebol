package com.denis.api.lnf.model.time;

import com.denis.api.lnf.model.enums.Divisao;

import java.time.LocalDate;
import java.util.UUID;

public record TimeResponseDTO(UUID id, String nome, Divisao divisao, LocalDate dataFundacao, String urlLogo) {
}
