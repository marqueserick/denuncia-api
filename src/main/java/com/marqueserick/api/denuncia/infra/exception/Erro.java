package com.marqueserick.api.denuncia.infra.exception;

import org.springframework.http.HttpStatus;

public class Erro extends RuntimeException {
    private String code;

    private HttpStatus httpStatus;

    public Erro(String message, String code, HttpStatus httpStatus){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

