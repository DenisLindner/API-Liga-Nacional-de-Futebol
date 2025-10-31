package com.denis.api.lnf.model.atleta;

import com.denis.api.lnf.model.time.Time;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "atletas")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInicioContrato;

    @Column(nullable = false)
    private LocalDate dataFimContrato;

    @Column(nullable = false)
    private String urlImagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTime", nullable = false)
    private Time time;

    public Atleta(AtletaRequestDTO data, Time time) {
        this.nome = data.nome();
        this.dataInicioContrato = data.dataInicioContrato();
        this.dataFimContrato = data.dataFimContrato();
        this.urlImagem = data.urlImagem();
        this.time = time;
    }
}
