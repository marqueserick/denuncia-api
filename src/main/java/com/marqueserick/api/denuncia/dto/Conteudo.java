package com.marqueserick.api.denuncia.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;

@ApiModel("Denuncia")
public class Conteudo {

    @JsonView(value = {Views.Requisicao.class})
    private String titulo;

    @JsonView(value = {Views.Requisicao.class})
    private String descricao;

    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
