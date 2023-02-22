package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Denunciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenuncianteRepository extends JpaRepository<Denunciante, Long> {
}
