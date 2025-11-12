package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.temporada.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, UUID> {
    boolean existsByConcluido(boolean concluido);
}
