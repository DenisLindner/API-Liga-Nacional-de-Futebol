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
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Divisao divisao;

    @Column(nullable = false)
    private LocalDate dataFundacao;

    @Column(nullable = false)
    private String urlLogo;

    public Time(TimeRequestDTO data){
        this.nome = data.nome();
        this.divisao = data.divisao();
        this.dataFundacao = data.dataFundacao();
        this.urlLogo = data.urlLogo();
    }
}
