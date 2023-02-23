package com.marqueserick.api.denuncia.dto;

import com.marqueserick.api.denuncia.model.Denuncia;

public class DenunciaDto {

    private Long id;

    private Double latitude;

    private Double longitude;

    private DenuncianteDto denunciante;

    private Conteudo denuncia;

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
