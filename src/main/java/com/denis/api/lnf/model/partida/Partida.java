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

    @Column(nullable = false)
    private LocalDateTime dataHorario;

    @Column(nullable = false)
    private String estadio;

    @Column(nullable = false)
    private Boolean concluido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMandante", nullable = false)
    private Time timeMandante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVisitante", nullable = false)
    private Time timeVisitante;

    public Partida(LocalDateTime dataHorario, String estadio, Time timeMandante, Time timeVisitante) {
        this.dataHorario = dataHorario;
        this.estadio = estadio;
        this.concluido = false;
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
    }
}
