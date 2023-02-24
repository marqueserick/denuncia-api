package com.marqueserick.api.denuncia.service;

import com.marqueserick.api.denuncia.dto.Endereco;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {

    @Mock
    EnderecoService enderecoService;

    @Test
    void deveRetornarMesmoObjeto(){

        when(enderecoService.buscarEndereco(-23.965511,-46.394040)).thenReturn(new Endereco());

        Endereco end1 = enderecoService.buscarEndereco(-23.965511,-46.394040);
        Endereco end2 = enderecoService.buscarEndereco(-23.965511,-46.394040);

        assertEquals(end1, end2);
    }

    @Test
    void deveRetornarNovoObjeto(){

        when(enderecoService.buscarEndereco(-23.965511,-46.394040)).thenReturn(new Endereco());

        Endereco end1 = enderecoService.buscarEndereco(-23.965511,-46.394040);
        Endereco end2 = enderecoService.buscarEndereco(-15.789925709252136,-47.887251273393815);

        assertNotEquals(end1, end2);
    }
}
