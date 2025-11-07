package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.partida.Partida;
import com.denis.api.lnf.model.partida.gol.Gol;
import com.denis.api.lnf.model.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GolRepository extends JpaRepository<Gol, UUID> {

    int countByPartidaAndAtleta_Time(Partida partida, Time atletaTime);
}
