package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.TimeNaoExisteException;
import com.denis.api.lnf.model.enums.Divisao;
import com.denis.api.lnf.model.time.Time;
import com.denis.api.lnf.model.time.TimeRequestDTO;
import com.denis.api.lnf.model.time.TimeResponseDTO;
import com.denis.api.lnf.repository.TimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TimeService {

    private TimeRepository timeRepository;

    public TimeResponseDTO cadastroTime(TimeRequestDTO data){
        Time time = new Time(data);
        return toResponse(timeRepository.save(time));
    }

    public Time buscarTimeCadastroAtleta(UUID id){
        return timeRepository.findById(id).orElseThrow(() -> new TimeNaoExisteException(id));
    }

    public int buscarQuantidadeTimesDivisao(Divisao divisao){
        return timeRepository.countByDivisao(divisao);
    }

    public List<Time> buscarTimesDivisao(Divisao divisao){
        return timeRepository.getAllByDivisao(divisao);
    }

    public boolean timeExiste(UUID id){
        return timeRepository.existsById(id);
    }

    public TimeResponseDTO toResponse(Time time){
        return new TimeResponseDTO(time.getId(), time.getNome(), time.getEstadio(), time.getDivisao(), time.getDataFundacao());
    }
}
