package com.denis.api.lnf.controller;

import com.denis.api.lnf.model.temporada.TemporadaRequestDTO;
import com.denis.api.lnf.model.temporada.TemporadaResponseDTO;
import com.denis.api.lnf.service.TemporadaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temporada")
@AllArgsConstructor
public class TemporadaController {

    private TemporadaService temporadaService;

    @PostMapping("/nova-temporada")
    public ResponseEntity<List<TemporadaResponseDTO>> novaTemporada(@RequestBody TemporadaRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(temporadaService.cadastroTemporada(data));
    }
}
