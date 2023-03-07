package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.enums.Status;
import com.flexpag.paymentscheduler.models.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Long SalvarAgendamento(Agendamento agendamento)
    {

        agendamento.setStatus(Status.peding);
        agendamentoRepository.save(agendamento);

        return agendamento.getId();
    }
    public String StatusAngendamento(Long id)
    {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Angendamento não existe"));

        return agendamento.getStatus().name();
    }

    public String DeletarAgendamento(Long id)
    {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Angendamento não existe"));

        if(agendamento.getStatus().name() == "paid")
        {
            new RuntimeException("Não é possível deletar um Agendamento já pago");
        }

        agendamentoRepository.deleteById(id);

        return "Agendamneto foi apagado";
    }

    public String AgendamentoAtulizar(Long id, Agendamento agendamento)
    {

        Agendamento agendamentobanco = agendamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O Angendamento não existe"));

        if(agendamentobanco.getStatus().name() == "paid")
        {
            new RuntimeException("Não é possível alterar a data de um Agendamento já pago");
        }

        agendamentobanco.setData(agendamento.getData());

        agendamentoRepository.save(agendamentobanco);

        return "Agendamento Atualizado com Sucesso";

    }
}
