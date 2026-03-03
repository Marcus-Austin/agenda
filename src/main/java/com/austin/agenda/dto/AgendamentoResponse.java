package com.austin.agenda.dto;

import java.time.LocalDateTime;

import com.austin.agenda.model.StatusAgendamento;

public record AgendamentoResponse(
    Long id,
    String titulo,
    String descricao,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    StatusAgendamento status,
    String usuario,
    LocalDateTime criadoEm,
    LocalDateTime atualizadoEm
) {

}
