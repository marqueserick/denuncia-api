package com.marqueserick.api.denuncia.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.marqueserick.api.denuncia.model.Denuncia;

public class DenunciaDto {

    @JsonView(value = {Views.Resposta.class})
    private Long id;

    @JsonView(value = {Views.Requisicao.class})
    private Double latitude;

    @JsonView(value = {Views.Requisicao.class})
    private Double longitude;

    @JsonView(value = {Views.Requisicao.class})
    private DenuncianteDto denunciante;

    @JsonView(value = {Views.Requisicao.class})
    private Conteudo denuncia;

    @JsonView(value = {Views.Resposta.class})
    private Endereco endereco;

    public DenunciaDto(Denuncia denuncia, Endereco endereco) {
        this.id = denuncia.getId();
        this.latitude = denuncia.getPonto().getLatitude();
        this.longitude = denuncia.getPonto().getLongitude();
        this.denunciante = new DenuncianteDto(denuncia.getDenunciante().getNome(), denuncia.getDenunciante().getCpf());
        this.denuncia = new Conteudo(denuncia.getTitulo(), denuncia.getDescricao());
        this.endereco = endereco;
    }

    public DenunciaDto(){}

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public DenuncianteDto getDenunciante() {
        return denunciante;
    }

    public Conteudo getDenuncia() {
        return denuncia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
}
