package com.austin.agenda.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.austin.agenda.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query("""
        SELECT CASE WHEN EXISTS(
            SELECT 1 FROM Agendamento e
            WHERE e.usuario = :usuario
            AND e.status = com.austin.agenda.model.StatusAgendamento.AGENDADO   
            AND (e.dataInicio < :fim AND e.dataFim > :inicio)
            AND (:ignoreId IS NULL OR e.id <> :ignoreId)
        ) THEN true ELSE false END
            """)
    boolean existsConflit(@Param("usuario") String usuario,
                         @Param("inicio") LocalDateTime inicio,
                         @Param("fim") LocalDateTime fim,
                         @Param("ignoreId") Long ignoreId);
}
