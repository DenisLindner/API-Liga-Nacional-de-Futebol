package com.denis.api.lnf.model.time;

import com.denis.api.lnf.model.enums.Divisao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "times")
@Table(name = "times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String estadio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Divisao divisao;

    @Column(nullable = false)
    private LocalDate dataFundacao;

    public Time(TimeRequestDTO data){
        this.nome = data.nome();
        this.divisao = data.divisao();
        this.dataFundacao = data.dataFundacao();
    }
}
