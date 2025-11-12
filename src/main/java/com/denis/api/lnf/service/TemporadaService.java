package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.QuantidadeTimesInvalidaException;
import com.denis.api.lnf.exception.TemporadaNaoConcluidaException;
import com.denis.api.lnf.model.enums.Divisao;
import com.denis.api.lnf.model.temporada.TemporadaRequestDTO;
import com.denis.api.lnf.model.temporada.TemporadaResponseDTO;
import com.denis.api.lnf.repository.TemporadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TemporadaService {

    private TemporadaRepository temporadaRepository;
    private TimeService timeService;

    public TemporadaResponseDTO cadastroTemporada(TemporadaRequestDTO data) {
        if (temporadaRepository.existsByConcluido(true)){
            throw new TemporadaNaoConcluidaException();
        }

        if (!(timeService.buscarQuantidadeTimesDivisao(Divisao.A) == 20 && timeService.buscarQuantidadeTimesDivisao(Divisao.B) == 20)){
            throw new QuantidadeTimesInvalidaException();
        }

    }
}
