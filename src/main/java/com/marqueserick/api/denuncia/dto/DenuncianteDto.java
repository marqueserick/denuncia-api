package com.marqueserick.api.denuncia.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;

@ApiModel("Denunciante")
public class DenuncianteDto {

    @JsonView(value = {Views.Requisicao.class})
    private String nome;

    @JsonView(value = {Views.Requisicao.class})
    private String cpf;

    public DenuncianteDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
