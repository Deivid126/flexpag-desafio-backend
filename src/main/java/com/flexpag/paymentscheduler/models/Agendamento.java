package com.flexpag.paymentscheduler.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "data")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;


}
