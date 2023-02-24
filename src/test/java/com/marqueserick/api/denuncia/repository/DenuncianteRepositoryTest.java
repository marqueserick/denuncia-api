package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Denunciante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@DataJpaTest
public class DenuncianteRepositoryTest {

    @Autowired
    private DenuncianteRepository denuncianteRepository;

    @Test
    void naoDeveRetornarDenunciante(){
        Optional<Denunciante> denunciante = denuncianteRepository.findByCpf(anyString());
        assertThrows(NoSuchElementException.class, () -> denunciante.get());
    }

    @Test
    void deveRetornarDenunciante(){
        Denunciante denunciante = new Denunciante(anyString(), anyString());
        denuncianteRepository.save(denunciante);

        Optional<Denunciante> denuncianteOptional = denuncianteRepository.findByCpf(anyString());
        assertTrue(denuncianteOptional.isPresent());
        assertFalse(denuncianteOptional.isEmpty());
        assertDoesNotThrow(() -> denuncianteOptional.get());

    }
}
