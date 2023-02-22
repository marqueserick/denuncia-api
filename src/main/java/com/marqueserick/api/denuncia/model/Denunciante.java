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

    private String cpf;

    @OneToMany(mappedBy = "denunciante")
    private List<Denuncia> denuncias;

}
