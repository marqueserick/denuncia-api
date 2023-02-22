package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}
