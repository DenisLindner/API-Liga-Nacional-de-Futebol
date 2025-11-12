package com.denis.api.lnf.model.temporada;

import com.denis.api.lnf.model.enums.Divisao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "temporadas")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Divisao divisao;

    @Column(nullable = false)
    private boolean concluido;

    public Temporada(TemporadaRequestDTO data, String nomeCampeonato, Divisao divisao) {
        this.nome = nomeCampeonato+" "+data.patrocinadoraMaster()+" "+data.dataInicio().getYear();
        this.dataInicio = data.dataInicio();
        this.divisao = divisao;
        this.concluido = false;
    }
}
