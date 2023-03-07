package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
