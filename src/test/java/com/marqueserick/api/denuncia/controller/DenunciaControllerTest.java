package com.marqueserick.api.denuncia.controller;

import com.google.gson.Gson;
import com.marqueserick.api.denuncia.dto.DenunciaDto;
import com.marqueserick.api.denuncia.dto.Endereco;
import com.marqueserick.api.denuncia.model.Denuncia;
import com.marqueserick.api.denuncia.model.Denunciante;
import com.marqueserick.api.denuncia.model.Ponto;
import com.marqueserick.api.denuncia.service.DenunciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class DenunciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DenunciaService service;

    private final String path = "/v1/denuncias";

    private DenunciaDto dto;

    @BeforeEach
    void init(){
        Ponto ponto = new Ponto(-23.965511,-46.394040);
        ponto.setId(1L);

        Denunciante denunciante = new Denunciante("Nome","56789012344");
        denunciante.setId(1L);

        Denuncia denuncia = new Denuncia();
        denuncia.setId(1L);
        denuncia.setTitulo("Titulo");
        denuncia.setDescricao("Descricao");
        denuncia.setPonto(ponto);
        denuncia.setDenunciante(denunciante);

        dto = new DenunciaDto(denuncia, new Endereco());
    }

    @Test
    void deveRetornarHttpStatus201() throws Exception {
        when(service.novaDenuncia(any(DenunciaDto.class))).thenReturn(dto);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post(path).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
