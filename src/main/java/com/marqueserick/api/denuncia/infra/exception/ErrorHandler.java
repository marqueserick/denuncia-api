package com.marqueserick.api.denuncia.infra.exception;

import com.marqueserick.api.denuncia.dto.Resposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Erro.class)
    public ResponseEntity erroDenuncia(Erro e){
        return new ResponseEntity(new Resposta(e.getMessage(), e.getCode()), e.getHttpStatus());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity erroNull(){
        return new ResponseEntity(new Resposta("Campos não podem ser nulos","04"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity erro(){
        return new ResponseEntity(new Resposta("Ocorreu um erro","00"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
