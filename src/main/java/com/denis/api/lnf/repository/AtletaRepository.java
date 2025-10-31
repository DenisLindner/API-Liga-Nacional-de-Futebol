package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.atleta.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, UUID> {
}
