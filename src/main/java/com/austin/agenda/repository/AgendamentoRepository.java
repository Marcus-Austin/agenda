package com.austin.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.austin.agenda.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
