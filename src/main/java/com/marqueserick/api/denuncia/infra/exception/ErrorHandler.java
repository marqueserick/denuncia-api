package com.marqueserick.api.denuncia.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Erro.class)
    public ResponseEntity erroDenuncia(Erro e){
        return new ResponseEntity(new ErroRetorno(e.getMessage(), e.getCode()), e.getHttpStatus());
    }
}
