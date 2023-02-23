package com.marqueserick.api.denuncia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_DENUNCIANTE")
public class Denunciante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "denunciante")
    private List<Denuncia> denuncias;

    public Denunciante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Denunciante(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
