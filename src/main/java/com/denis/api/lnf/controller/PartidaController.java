package com.denis.api.lnf.controller;

import com.denis.api.lnf.model.partida.PartidaResponseDTO;
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
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.getAllPartidasTemporada(temporadaService.getTemporadaById(UUID.fromString(idTemporada))));
    }
}
