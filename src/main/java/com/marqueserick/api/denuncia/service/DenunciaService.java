package com.marqueserick.api.denuncia.service;

import com.marqueserick.api.denuncia.dto.DenunciaDto;
import com.marqueserick.api.denuncia.dto.Endereco;
import com.marqueserick.api.denuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public DenunciaDto novaDenuncia(DenunciaDto denuncia) {
        Endereco endereco = enderecoService.buscarEndereco(denuncia.getLatitude(), denuncia.getLongitude());
        denuncia.setEndereco(endereco);
        return denuncia;
    }
}
