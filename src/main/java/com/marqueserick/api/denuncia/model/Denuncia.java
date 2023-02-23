package com.marqueserick.api.denuncia.model;

import javax.persistence.*;

@Entity
@Table(name="TB_DENUNCIA")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_ponto", nullable = false)
    private Ponto ponto;

    @ManyToOne
    @JoinColumn(name = "id_denunciante", nullable = false)
    private Denunciante denunciante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public Denunciante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }
}
