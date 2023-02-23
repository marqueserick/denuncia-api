package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Denunciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DenuncianteRepository extends JpaRepository<Denunciante, Long> {
    Optional<Denunciante> findByCpf(String cpf);
}
