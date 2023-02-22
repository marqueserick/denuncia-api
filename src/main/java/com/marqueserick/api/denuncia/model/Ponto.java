package com.marqueserick.api.denuncia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PONTO")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "ponto")
    private List<Denuncia> denuncias;
}
