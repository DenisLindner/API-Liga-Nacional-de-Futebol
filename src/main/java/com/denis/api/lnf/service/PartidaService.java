package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.TimesDiferentesDivisoesException;
import com.denis.api.lnf.model.partida.Partida;
import com.denis.api.lnf.model.partida.PartidaRequestDTO;
import com.denis.api.lnf.model.partida.PartidaResponseDTO;
import com.denis.api.lnf.repository.CartaoRepository;
import com.denis.api.lnf.repository.GolRepository;
import com.denis.api.lnf.repository.PartidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartidaService {

    private PartidaRepository partidaRepository;
    private CartaoRepository cartaoRepository;
    private GolRepository golRepository;

    public PartidaResponseDTO cadastroPartida(PartidaRequestDTO data) {
        if (!data.timeMandante().getDivisao().equals(data.timeVisitante().getDivisao())){
            throw new TimesDiferentesDivisoesException(data.timeMandante().getNome(), data.timeVisitante().getNome());
        }
        Partida partida = new Partida(data.dataHorario(), data.timeMandante().getEstadio(), data.timeMandante(), data.timeVisitante());
        return toResponse(partidaRepository.save(partida));
    }

    public PartidaResponseDTO toResponse(Partida partida){
        return new PartidaResponseDTO(partida.getId(), partida.getDataHorario(), partida.getEstadio(), partida.getTimeMandante(), partida.getTimeVisitante(), String.valueOf(getGolsTimeMandante(partida)), String.valueOf(getGolsTimeVisitane(partida)));
    }

    public int getGolsTimeMandante(Partida partida){
        return golRepository.countByPartidaAndAtleta_Time(partida, partida.getTimeMandante());
    }

    public int getGolsTimeVisitane(Partida partida){
        return golRepository.countByPartidaAndAtleta_Time(partida, partida.getTimeVisitante());
    }
}
