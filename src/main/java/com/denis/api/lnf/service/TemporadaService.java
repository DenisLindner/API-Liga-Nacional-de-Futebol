package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.QuantidadeTimesInvalidaException;
import com.denis.api.lnf.exception.TemporadaNaoConcluidaException;
import com.denis.api.lnf.exception.TemporadaNaoExisteException;
import com.denis.api.lnf.model.enums.Divisao;
import com.denis.api.lnf.model.temporada.Temporada;
import com.denis.api.lnf.model.temporada.TemporadaRequestDTO;
import com.denis.api.lnf.model.temporada.TemporadaResponseDTO;
import com.denis.api.lnf.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TemporadaService {

    private final TemporadaRepository temporadaRepository;
    private final TimeService timeService;
    private final PartidaService partidaService;
    private final String nomeCampeonato;

    @Autowired
    public TemporadaService(TemporadaRepository temporadaRepository, TimeService timeService, PartidaService partidaService, @Value("${valor.nome.campeonato}") String nomeCampeonato) {
        this.temporadaRepository = temporadaRepository;
        this.timeService = timeService;
        this.partidaService = partidaService;
        this.nomeCampeonato = nomeCampeonato;
    }

    public List<TemporadaResponseDTO> cadastroTemporada(TemporadaRequestDTO data) {
        if (temporadaRepository.existsByConcluido(true)){
            throw new TemporadaNaoConcluidaException();
        }

        if (!(timeService.buscarQuantidadeTimesDivisao(Divisao.A) == 20 && timeService.buscarQuantidadeTimesDivisao(Divisao.B) == 20)){
            throw new QuantidadeTimesInvalidaException();
        }

        List<TemporadaResponseDTO> temporadaResponseDTOList = new ArrayList<>();
        Temporada temporadaA = temporadaRepository.save(new Temporada(data, nomeCampeonato, Divisao.A));
        Temporada temporadaB = temporadaRepository.save(new Temporada(data, nomeCampeonato, Divisao.B));
        partidaService.calcularPartidas(temporadaA);
        partidaService.calcularPartidas(temporadaB);
        temporadaResponseDTOList.add(toResponseDTO(temporadaA));
        temporadaResponseDTOList.add(toResponseDTO(temporadaB));
        return temporadaResponseDTOList;
    }

    public Temporada getTemporadaById(UUID id) {
        Temporada temporada = temporadaRepository.getDistinctById(id);
        if (temporada == null){
            throw new TemporadaNaoExisteException(id);
        }
        return temporada;
    }

    public TemporadaResponseDTO toResponseDTO(Temporada temporada) {
        return new TemporadaResponseDTO(temporada.getId(), temporada.getNome(), temporada.getDataInicio(), temporada.getDivisao(), temporada.isConcluido());
    }
}
