package com.austin.agenda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.austin.agenda.dto.AgendamentoCreateRequest;
import com.austin.agenda.dto.AgendamentoResponse;
import com.austin.agenda.dto.AgendamentoUpdateRequest;
import com.austin.agenda.service.AgendamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public AgendamentoResponse criar(@RequestBody @Valid AgendamentoCreateRequest req){
        return service.criar(req);
    }

    @PutMapping("/{id}")
    public AgendamentoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AgendamentoUpdateRequest req){
        return service.atualizar(id, req);
    }

    @PutMapping("/{id}/cancelar")
    public AgendamentoResponse cancelar(@PathVariable Long id){
        return service.cancelar(id);
    }

    @PutMapping("/{id}/concluir")
    public AgendamentoResponse concluir(@PathVariable Long id){
        return service.concluir(id);
    }

    @GetMapping("/{id}")
    public AgendamentoResponse buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

}
