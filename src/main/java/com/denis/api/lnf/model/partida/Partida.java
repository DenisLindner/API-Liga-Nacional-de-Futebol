package com.denis.api.lnf.model.partida;

import com.denis.api.lnf.model.temporada.Temporada;
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

    @Column(nullable = false)
    private LocalDateTime dataHorario;

    @Column(nullable = false)
    private String estadio;

    @Column(nullable = false)
    private Boolean concluido;

    @Column(nullable = false)
    private int rodada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMandante", nullable = false)
    private Time timeMandante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVisitante", nullable = false)
    private Time timeVisitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTemporada", nullable = false)
    private Temporada temporada;

    public Partida(PartidaRequestDTO data) {
        this.dataHorario = data.dataHorario();
        this.estadio = data.estadio();
        this.concluido = false;
        this.rodada = data.rodada();
        this.timeMandante = data.timeMandante();
        this.timeVisitante = data.timeVisitante();
        this.temporada = data.temporada();
    }
}
