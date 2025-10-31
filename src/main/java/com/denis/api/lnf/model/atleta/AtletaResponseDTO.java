package com.denis.api.lnf.model.atleta;

import com.denis.api.lnf.model.time.Time;

import java.time.LocalDate;
import java.util.UUID;

public record AtletaResponseDTO(UUID id, String nome, Time time, LocalDate dataInicioContrato, LocalDate dataFimContrato, String urlImagem) {
}
