package com.marqueserick.api.denuncia.dto;

public class DenuncianteDto {

    private String nome;

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
