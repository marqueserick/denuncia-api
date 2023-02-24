package com.marqueserick.api.denuncia.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.marqueserick.api.denuncia.dto.Conteudo;
import com.marqueserick.api.denuncia.dto.DenunciaDto;
import com.marqueserick.api.denuncia.dto.DenuncianteDto;
import com.marqueserick.api.denuncia.dto.Endereco;
import com.marqueserick.api.denuncia.model.Denuncia;
import com.marqueserick.api.denuncia.model.Denunciante;
import com.marqueserick.api.denuncia.model.Ponto;
import com.marqueserick.api.denuncia.repository.DenunciaRepository;
import com.marqueserick.api.denuncia.repository.DenuncianteRepository;
import com.marqueserick.api.denuncia.repository.PontoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class DenunciaServiceTest {

    @Mock
    private DenunciaRepository denunciaRepository;

    @Mock
    private PontoRepository pontoRepository;

    @Mock
    private DenuncianteRepository denuncianteRepository;

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private DenunciaService denunciaService;

    private Endereco endereco;

    private Denunciante denunciante;

    private Denuncia denuncia;

    @BeforeEach
    void init(){
        JsonObject jo = new JsonObject();
        jo.add("street", new Gson().toJsonTree("xpto"));
        jo.add("adminArea6", new Gson().toJsonTree("xpto"));
        jo.add("adminArea5", new Gson().toJsonTree("xpto"));
        jo.add("adminArea3", new Gson().toJsonTree("xpto"));
        jo.add("adminArea1", new Gson().toJsonTree("xpto"));
        jo.add("postalCode", new Gson().toJsonTree("xpto"));
        endereco = new Endereco(jo);

        denunciante = new Denunciante("Nome","5634546");
    }

    @Test
    void deveRetornarDenunciaDto(){
        DenunciaDto dto = new DenunciaDto();
        dto.setLatitude(-23.965511);
        dto.setLongitude(-46.394040);
        dto.setDenunciante(new DenuncianteDto(denunciante.getNome(), denunciante.getCpf()));
        dto.setDenuncia(new Conteudo("Titulo","Descricao"));

        lenient().when(pontoRepository.findByLatitudeAndLongitude(anyDouble(), anyDouble())).thenReturn(Arrays.asList(new Ponto()));
        lenient().when(enderecoService.buscarEndereco(anyDouble(), anyDouble())).thenReturn(endereco);
        lenient().when(denuncianteRepository.findByCpf(anyString())).thenReturn(Optional.of(denunciante));
        lenient().when(denunciaRepository.save(denuncia)).thenReturn(denuncia);

        DenunciaDto dtoRetornado = denunciaService.novaDenuncia(dto);

        assertEquals(dtoRetornado.getId(), dto.getId());
        assertNotNull(dtoRetornado);
    }
}
