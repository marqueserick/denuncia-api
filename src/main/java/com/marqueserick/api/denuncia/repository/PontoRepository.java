package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {
}
