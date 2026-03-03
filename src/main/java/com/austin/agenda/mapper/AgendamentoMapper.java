package com.austin.agenda.mapper;

import java.time.LocalDateTime;

import com.austin.agenda.dto.AgendamentoCreateRequest;
import com.austin.agenda.dto.AgendamentoResponse;
import com.austin.agenda.dto.AgendamentoUpdateRequest;
import com.austin.agenda.model.Agendamento;
import com.austin.agenda.model.StatusAgendamento;

public class AgendamentoMapper {

    public static Agendamento toEntity (AgendamentoCreateRequest req){
        
        return Agendamento.builder()
                .titulo(req.titulo())
                .descricao(req.descricao())
                .dataInicio(req.dataInicio())
                .dataFim(req.dataFim())
                .status(StatusAgendamento.AGENDADO)
                .usuario(req.usuario())
                .criadoEm(LocalDateTime.now())
                .atualizadoEm(LocalDateTime.now())
                .build();   
    }

    public void merge (Agendamento entity, AgendamentoUpdateRequest req){
        if(req.titulo() != null){
            entity.setTitulo(req.titulo());
        }
        if(req.descricao() != null){
            entity.setDescricao(req.descricao());
        }
        if(req.dataInicio() != null){
            entity.setDataInicio(req.dataInicio());
        }
        if(req.dataFim() != null){
            entity.setDataFim(req.dataFim());
        }
       
        entity.setAtualizadoEm(LocalDateTime.now());
    }

    public static AgendamentoResponse toResponse(Agendamento e){
        return new AgendamentoResponse(
            e.getId(),
            e.getTitulo(),
            e.getDescricao(),
            e.getDataInicio(),
            e.getDataFim(),
            e.getStatus(),
            e.getUsuario(),
            e.getCriadoEm(),
            e.getAtualizadoEm()
        );
    }
}
