package com.denis.api.lnf.model.partida.cartao;

import com.denis.api.lnf.model.atleta.Atleta;
import com.denis.api.lnf.model.enums.TipoCartao;
import com.denis.api.lnf.model.partida.Partida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "cartoes")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private int minuto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAtleta", nullable = false)
    private Atleta atleta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPartida", nullable = false)
    private Partida partida;
}
