package com.marqueserick.api.denuncia.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.JsonObject;

public class Endereco {

    @JsonView(value = {Views.Resposta.class})
    private String logradouro;

    @JsonView(value = {Views.Resposta.class})
    private String bairro;

    @JsonView(value = {Views.Resposta.class})
    private String cidade;

    @JsonView(value = {Views.Resposta.class})
    private String estado;

    @JsonView(value = {Views.Resposta.class})
    private String pais;

    //@JsonView(value = {Views.Resposta.class})
    private String cep;

    public Endereco(JsonObject enderecoJson) {
        this.logradouro = enderecoJson.get("street").getAsString();
        this.bairro = enderecoJson.get("adminArea6").getAsString();
        this.cidade = enderecoJson.get("adminArea5").getAsString();
        this.estado = enderecoJson.get("adminArea3").getAsString();
        this.pais = enderecoJson.get("adminArea1").getAsString();
        this.cep = enderecoJson.get("postalCode").getAsString();
    }

    public Endereco() {

    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }
}
