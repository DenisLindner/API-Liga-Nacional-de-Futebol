package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.partida.Partida;
import com.denis.api.lnf.model.temporada.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, UUID> {
    Partida getDistinctById(UUID id);

    List<Partida> getAllByTemporada(Temporada temporada);

    List<Partida> getAllByTemporadaAndRodada(Temporada temporada, int rodada);
}
