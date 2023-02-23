package com.marqueserick.api.denuncia.dto;

public class DenunciaDto {

    private Long id;

    private Double latitude;

    private Double longitude;

    private DenuncianteDto denunciante;

    private Conteudo denuncia;

    private Endereco endereco;

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
