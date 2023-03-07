package com.flexpag.paymentscheduler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice(basePackages = "com.flexpag.paymentscheduler.controller")
public class ApiException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> hadlererror(RuntimeException run, WebRequest request)
    {
        MensagemNotFound erro = new MensagemNotFound(run.getMessage(),new Date(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);

    }
}
