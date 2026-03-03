package com.austin.agenda.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
public record AgendamentoCreateRequest(
    @NotBlank @Size(max = 120) String titulo,
    @NotBlank @Size(max = 4000) String descricao,
    @NotNull LocalDateTime dataInicio,
    @NotNull LocalDateTime dataFim,
    @NotNull @Size(max = 88) String usuario
) {

}
