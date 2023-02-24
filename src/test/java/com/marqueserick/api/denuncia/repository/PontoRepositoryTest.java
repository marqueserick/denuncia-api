package com.marqueserick.api.denuncia.repository;

import com.marqueserick.api.denuncia.model.Ponto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;

@DataJpaTest
public class PontoRepositoryTest {

    @Autowired
    PontoRepository pontoRepository;

    @Test
    void deveRetornarListaVazia(){
        List<Ponto> pontos = pontoRepository.findByLatitudeAndLongitude(anyDouble(), anyDouble());

        assertTrue(pontos.size() == 0);
        assertTrue(pontos.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> pontos.get(0));
    }

    @Test
    void deveRetornarListaComPontos(){
        for(int i =0; i<3; i++){
            Ponto ponto = new Ponto(anyDouble(), anyDouble());
            pontoRepository.save(ponto);
        }

        List<Ponto> pontos = pontoRepository.findByLatitudeAndLongitude(anyDouble(), anyDouble());

        assertTrue(pontos.size() == 3);
        assertFalse(pontos.isEmpty());
        assertNotNull(pontos.get(0));
        assertDoesNotThrow(() -> pontos.get(0));

    }
}
