package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.TimeNaoExisteException;
import com.denis.api.lnf.model.atleta.Atleta;
import com.denis.api.lnf.model.atleta.AtletaRequestDTO;
import com.denis.api.lnf.model.atleta.AtletaResponseDTO;
import com.denis.api.lnf.repository.AtletaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtletaService {

    private AtletaRepository atletaRepository;
    private TimeService timeService;

    public AtletaResponseDTO cadastroAtleta(AtletaRequestDTO data) {
        if (!timeService.timeExiste(data.idTime())){
            throw new TimeNaoExisteException(data.idTime());
        }
        Atleta atleta = new Atleta(data, timeService.buscarTimeCadastroAtleta(data.idTime()));
        return toResponse(atletaRepository.save(atleta));
    }

    public AtletaResponseDTO toResponse(Atleta atleta) {
        return new AtletaResponseDTO(atleta.getId(), atleta.getNome(), atleta.getTime(), atleta.getDataInicioContrato(), atleta.getDataFimContrato(), atleta.getUrlImagem());
    }
}
