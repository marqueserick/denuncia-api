package com.marqueserick.api.denuncia.service;

import com.marqueserick.api.denuncia.dto.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class EnderecoServiceTest {

    @Autowired
    EnderecoService enderecoService;

    @Test
    void deveRetornarMesmoObjeto(){
        Endereco end1 = enderecoService.buscarEndereco(-23.965511,-46.394040);
        Endereco end2 = enderecoService.buscarEndereco(-23.965511,-46.394040);
        assertEquals(end1, end2);
    }

    @Test
    void deveRetornarNovoObjeto(){
        Endereco end1 = enderecoService.buscarEndereco(-23.965511,-46.394040);
        Endereco end2 = enderecoService.buscarEndereco(-15.789925709252136,-47.887251273393815);
        assertNotEquals(end1, end2);
    }
}
