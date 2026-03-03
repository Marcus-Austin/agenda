package com.austin.agenda.service;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.austin.agenda.dto.AgendamentoCreateRequest;
import com.austin.agenda.dto.AgendamentoResponse;
import com.austin.agenda.dto.AgendamentoUpdateRequest;
import com.austin.agenda.mapper.AgendamentoMapper;
import com.austin.agenda.model.Agendamento;
import com.austin.agenda.model.StatusAgendamento;
import com.austin.agenda.repository.AgendamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
@Service
public class AgendamentoService {

    private final AgendamentoRepository repo;

    public AgendamentoService(AgendamentoRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public AgendamentoResponse criar(@Valid AgendamentoCreateRequest req){

        validarIntervalor(req.dataInicio(), req.dataFim());
        checkConflito(req.usuario(), req.dataInicio(), req.dataFim(), null);

        Agendamento entity = AgendamentoMapper.toEntity(req);
        entity = repo.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse atualizar(Long id, @Valid AgendamentoUpdateRequest req){
        Agendamento entity = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        AgendamentoMapper agendamentoMapper = new AgendamentoMapper();
        agendamentoMapper.merge(entity, req);
        validarIntervalor(req.dataInicio(), req.dataFim());
        checkConflito(entity.getUsuario(), req.dataInicio(), req.dataFim(), entity.getId());
        entity = repo.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse cancelar(Long id){
    Agendamento entity = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        entity.setStatus(StatusAgendamento.CANCELADO);
        entity = repo.save(entity);
        return AgendamentoMapper.toResponse(entity);    
    }

    @Transactional
    public AgendamentoResponse concluir(Long id){
    Agendamento entity = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        entity.setStatus(StatusAgendamento.CONCLUIDO);
        entity = repo.save(entity);
        return AgendamentoMapper.toResponse(entity);    
    }

    public AgendamentoResponse buscarPorId(Long id){
        Agendamento e = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        return AgendamentoMapper.toResponse(e);
    }


    private void validarIntervalor(LocalDateTime inicio, LocalDateTime fim){
        if(inicio == null || fim == null || !inicio.isBefore(fim)){
            throw new IllegalArgumentException("Intervalo de datas inválido");
        }
    }

    private void checkConflito(String usuario, LocalDateTime inicio, LocalDateTime fim, Long id){
        if(repo.existsConflit(usuario, inicio, fim, id)){
            throw new IllegalArgumentException("Conflito de agendamento");
        }
    }
}
