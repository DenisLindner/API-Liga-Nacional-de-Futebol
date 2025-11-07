package com.denis.api.lnf.model.partida.gol;

import com.denis.api.lnf.model.atleta.Atleta;
import com.denis.api.lnf.model.partida.Partida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "gols")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gol {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private int minuto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAtleta", nullable = false)
    private Atleta atleta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPartida", nullable = false)
    private Partida partida;
}
