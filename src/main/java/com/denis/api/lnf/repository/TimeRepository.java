package com.denis.api.lnf.repository;

import com.denis.api.lnf.model.enums.Divisao;
import com.denis.api.lnf.model.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TimeRepository extends JpaRepository<Time, UUID> {

    int countByDivisao(Divisao divisao);

    List<Time> getAllByDivisao(Divisao divisao);
}
