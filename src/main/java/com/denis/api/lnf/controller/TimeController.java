package com.denis.api.lnf.controller;

import com.denis.api.lnf.model.time.TimeRequestDTO;
import com.denis.api.lnf.model.time.TimeResponseDTO;
import com.denis.api.lnf.service.TimeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time")
@AllArgsConstructor
public class TimeController {

    public TimeService timeService;

    @PostMapping("/cadastro-time")
    public ResponseEntity<TimeResponseDTO> cadastroTime(@RequestBody @Valid TimeRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.cadastroTime(data));
    }

    @PostMapping("/cadastro-times")
    public ResponseEntity<List<TimeResponseDTO>> cadastroTimes(@RequestBody @Valid List<TimeRequestDTO> data){
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.cadastroTimes(data));
    }
}
