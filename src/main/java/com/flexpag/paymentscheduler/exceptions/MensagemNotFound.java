package com.flexpag.paymentscheduler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MensagemNotFound {
    private String msg;
    private Date data;
    private Integer status;
}
