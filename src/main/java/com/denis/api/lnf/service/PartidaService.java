package com.denis.api.lnf.service;

import com.denis.api.lnf.exception.PartidaNaoEncontradaException;
import com.denis.api.lnf.exception.TemporadaJaConcluidaException;
import com.denis.api.lnf.exception.TimesDiferentesDivisoesException;
import com.denis.api.lnf.model.partida.Partida;
import com.denis.api.lnf.model.partida.PartidaDetalhadaResponseDTO;
import com.denis.api.lnf.model.partida.PartidaRequestDTO;
import com.denis.api.lnf.model.partida.PartidaResponseDTO;
import com.denis.api.lnf.model.partida.cartao.Cartao;
import com.denis.api.lnf.model.partida.cartao.CartaoListaResponseDTO;
import com.denis.api.lnf.model.partida.gol.Gol;
import com.denis.api.lnf.model.partida.gol.GolListaResponseDTO;
import com.denis.api.lnf.model.temporada.Temporada;
import com.denis.api.lnf.model.time.Time;
import com.denis.api.lnf.repository.CartaoRepository;
import com.denis.api.lnf.repository.GolRepository;
import com.denis.api.lnf.repository.PartidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class PartidaService {

    private PartidaRepository partidaRepository;
    private CartaoRepository cartaoRepository;
    private GolRepository golRepository;

    private TimeService timeService;

    public void cadastroPartida(PartidaRequestDTO data) {
        if (!data.timeMandante().getDivisao().equals(data.timeVisitante().getDivisao())){
            throw new TimesDiferentesDivisoesException(data.timeMandante().getNome(), data.timeVisitante().getNome());
        }
        if (data.temporada().isConcluido()){
            throw new TemporadaJaConcluidaException();
        }
        Partida partida = new Partida(data);
        partidaRepository.save(partida);
    }

    public PartidaDetalhadaResponseDTO getPartidaDetalhada(UUID id) {
        Partida partida = partidaRepository.getDistinctById(id);
        if (partida == null) {
            throw new PartidaNaoEncontradaException(id);
        }

        return toDetalhada(partida);
    }

    public int getQuantidadeGolsTimeMandante(Partida partida){
        return golRepository.countByPartidaAndAtleta_Time(partida, partida.getTimeMandante());
    }

    public int getQuantidadeGolsTimeVisitane(Partida partida){
        return golRepository.countByPartidaAndAtleta_Time(partida, partida.getTimeVisitante());
    }

    public List<GolListaResponseDTO> getGolsListaResponse(Partida partida){
        return golRepository.getAllByPartida(partida).stream().map(this::toGolsListaResponse).toList();
    }

    public List<CartaoListaResponseDTO> getCartaoListaResponse(Partida partida){
        return cartaoRepository.getAllByPartida(partida).stream().map(this::toCartaoListaResponse).toList();
    }

    public PartidaResponseDTO toResponse(Partida partida){
        return new PartidaResponseDTO(partida.getId(), partida.getDataHorario(), partida.getEstadio(), partida.getRodada(), partida.getTimeMandante().getNome(), partida.getTimeVisitante().getNome(), String.valueOf(getQuantidadeGolsTimeMandante(partida)), String.valueOf(getQuantidadeGolsTimeVisitane(partida)), partida.getTemporada().getNome());
    }

    public PartidaDetalhadaResponseDTO toDetalhada(Partida partida){
        return new PartidaDetalhadaResponseDTO(partida.getId(), partida.getDataHorario(), partida.getEstadio(), partida.getRodada(), partida.getTimeMandante().getNome(), partida.getTimeVisitante().getNome(), String.valueOf(getQuantidadeGolsTimeMandante(partida)), String.valueOf(getQuantidadeGolsTimeVisitane(partida)), partida.getTemporada().getNome(), getGolsListaResponse(partida), getCartaoListaResponse(partida));
    }

    public GolListaResponseDTO toGolsListaResponse(Gol gol){
        return new GolListaResponseDTO(gol.getId(), gol.getMinuto(), gol.getAtleta().getNome(), gol.getAtleta().getTime().getNome());
    }

    public CartaoListaResponseDTO toCartaoListaResponse(Cartao cartao){
        return new CartaoListaResponseDTO(cartao.getId(), cartao.getMinuto(), cartao.getTipoCartao(), cartao.getAtleta().getNome(), cartao.getAtleta().getTime().getNome());
    }


    public List<PartidaResponseDTO> getAllPartidasTemporada(Temporada temporada){
        return partidaRepository.getAllByTemporada(temporada).stream().map(this::toResponse).toList();
    }

    public List<PartidaResponseDTO> getAllPartidasTemporadaAndRodada(Temporada temporada, int rodada){
        return partidaRepository.getAllByTemporadaAndRodada(temporada, rodada).stream().map(this::toResponse).toList();
    }



    public void calcularPartidas(Temporada temporada){
        List<Time> times = timeService.buscarTimesDivisao(temporada.getDivisao());
        Map<Integer, Time> timesOrdenados = timesOrdenadosCalculo(times);

        List<PartidaRequestDTO> partidasRequest = new ArrayList<>();

        boolean mandante = false;

        LocalDateTime dataInicio = LocalDateTime.of(temporada.getDataInicio().getYear(), temporada.getDataInicio().getMonth(), temporada.getDataInicio().getDayOfMonth(), 19, 30);
        for (int a = 1; a <= 2; a++){
            for (int b = 1; b <= 19; b++){
                int[] posicoes = timesPosicao(b);
                LocalDateTime dataHora = dataInicio.plusDays((a*b-1)* 7L);
                for (int c = 1; c <= 10; c++){
                    if (mandante){
                        if (c == 9){
                            partidasRequest.add(new PartidaRequestDTO(dataHora, timesOrdenados.get(posicoes[c]).getEstadio(), a*b, timesOrdenados.get(posicoes[c]), timesOrdenados.get(19), temporada));
                        } else {
                            partidasRequest.add(new PartidaRequestDTO(dataHora, timesOrdenados.get(posicoes[c]).getEstadio(), a*b, timesOrdenados.get(posicoes[c]), timesOrdenados.get(posicoes[18-c]), temporada));
                        }
                    } else {
                        if (c == 9){
                            partidasRequest.add(new PartidaRequestDTO(dataHora, timesOrdenados.get(19).getEstadio(), a*b, timesOrdenados.get(19), timesOrdenados.get(posicoes[c]), temporada));
                        } else {
                            partidasRequest.add(new PartidaRequestDTO(dataHora, timesOrdenados.get(posicoes[18-c]).getEstadio(), a*b, timesOrdenados.get(posicoes[18-c]), timesOrdenados.get(c), temporada));
                        }
                    }
                }
                mandante = !mandante;
            }
        }

        for (PartidaRequestDTO partidaRequest : partidasRequest){
            cadastroPartida(partidaRequest);
        }
    }

    public Map<Integer, Time> timesOrdenadosCalculo(List<Time> times){
        Map<Integer, Time> timesOrdenados = new HashMap<>();

        int numero = 0;
        for (Time time : times){
            timesOrdenados.put(numero, time);
            numero++;
        }

        return timesOrdenados;
    }

    public int[] timesPosicao(int rodada){
        int[] timesPosicoes = new int[19];
        for (int i = 0; i < 19; i++){
            if (i+rodada > 18){
                timesPosicoes[i+rodada-19] = i;
            } else {
                timesPosicoes[i+rodada] = i;
            }
        }
        return timesPosicoes;
    }
}
