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

    public Ponto(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Ponto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
