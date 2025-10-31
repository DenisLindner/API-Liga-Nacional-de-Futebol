package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.time.Time;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "partidas")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    private LocalDateTime dataHorario;
    private String estadio;
    private Boolean concluido = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMandante", nullable = false)
    private Time timeMandante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVisitante", nullable = false)
    private Time timeVisitante;


}
