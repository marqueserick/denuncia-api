package com.marqueserick.api.denuncia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.marqueserick.api.denuncia.infra.exception.ErroRetorno;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resposta {

    private DenunciaDto data;
    private ErroRetorno error;

    public Resposta(DenunciaDto data){
        this.data = data;
    }

    public Resposta(String message, String code){
        ErroRetorno e = new ErroRetorno(message,code);
        this.error = e;
    }

    public DenunciaDto getData() {
        return data;
    }

    public ErroRetorno getError() {
        return error;
    }
}
