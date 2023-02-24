package com.marqueserick.api.denuncia.infra.exception;

public class ErroRetorno {

    private String message;

    private String code;

    public ErroRetorno(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
