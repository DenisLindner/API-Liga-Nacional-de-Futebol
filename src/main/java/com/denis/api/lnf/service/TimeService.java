package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.MaximoDeTimesDivisaoException;
import com.denis.api.lnf.exception.TimeNaoExisteException;
import com.denis.api.lnf.model.enums.Divisao;
import com.denis.api.lnf.model.time.Time;
import com.denis.api.lnf.model.time.TimeRequestDTO;
import com.denis.api.lnf.model.time.TimeResponseDTO;
import com.denis.api.lnf.repository.TimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TimeService {

    private TimeRepository timeRepository;

    public TimeResponseDTO cadastroTime(TimeRequestDTO data){
        if (timeRepository.countByDivisao(data.divisao()) >= 20){
            throw new MaximoDeTimesDivisaoException(data.divisao());
        }
        Time time = new Time(data);
        return toResponse(timeRepository.save(time));
    }

    public List<TimeResponseDTO> cadastroTimes(List<TimeRequestDTO> data){
        List<TimeResponseDTO> times = new ArrayList<>();
        for(TimeRequestDTO dto : data){
            times.add(cadastroTime(dto));
        }
        return times;
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
