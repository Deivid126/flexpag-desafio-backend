package com.flexpag.paymentscheduler.controller;

import com.flexpag.paymentscheduler.models.Agendamento;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/agendamentos")
@AllArgsConstructor
public class AgendamentoController {

    private final AgendamentoService angendamentoService;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Agendamento agendamento)
    {
        Long id = angendamentoService.SalvarAgendamento(agendamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getagendamento(@PathVariable(name = "id") Long id)
    {
        String respota = angendamentoService.StatusAngendamento(id);

        return ResponseEntity.status(HttpStatus.OK).body(respota);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable(name = "id") Long id)
    {
        String deleteresposta = angendamentoService.DeletarAgendamento(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteresposta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable(name = "id") Long id, @RequestBody Agendamento agendamento)
    {
        String atualiar = angendamentoService.AgendamentoAtulizar(id,agendamento);

        return ResponseEntity.status(HttpStatus.OK).body(atualiar);
    }
}
