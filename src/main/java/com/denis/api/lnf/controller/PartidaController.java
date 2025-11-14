package com.denis.api.lnf.controller;

import com.denis.api.lnf.model.partida.PartidaResponseDTO;
import com.denis.api.lnf.model.temporada.Temporada;
import com.denis.api.lnf.service.PartidaService;
import com.denis.api.lnf.service.TemporadaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/partida")
@AllArgsConstructor
public class PartidaController {

    private PartidaService partidaService;
    private TemporadaService temporadaService;

    @GetMapping("/partidas-temporada/{idTemporada}")
    public ResponseEntity<List<PartidaResponseDTO>> getAllPartidasByTemporada(@PathVariable @Valid String idTemporada){
        Temporada temporada = temporadaService.getTemporadaById(UUID.fromString(idTemporada));
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.getAllPartidasTemporada(temporada));
    }

    @GetMapping("/partidas-temporada-rodada/{idTemporada}{rodada}")
    public ResponseEntity<List<PartidaResponseDTO>> getAllPartidasByTemporada(@PathVariable @Valid String idTemporada, @PathVariable @Valid int rodada){
        Temporada temporada = temporadaService.getTemporadaById(UUID.fromString(idTemporada));
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.getAllPartidasTemporadaAndRodada(temporada,rodada));
    }
}
