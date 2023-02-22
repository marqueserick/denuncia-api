package com.marqueserick.api.denuncia.model;

import javax.persistence.*;

@Entity
@Table(name="TB_DENUNCIA")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "id_ponto", nullable = false)
    private Ponto ponto;

    @ManyToOne
    @JoinColumn(name = "id_denunciante", nullable = false)
    private Denunciante denunciante;
}
