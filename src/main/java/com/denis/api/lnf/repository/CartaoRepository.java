package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.partida.Partida;
import com.denis.api.lnf.model.partida.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, UUID> {

    List<Cartao> getAllByPartida(Partida partida);
}
