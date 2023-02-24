package com.marqueserick.api.denuncia.service;

import com.marqueserick.api.denuncia.dto.DenunciaDto;
import com.marqueserick.api.denuncia.dto.DenuncianteDto;
import com.marqueserick.api.denuncia.dto.Endereco;
import com.marqueserick.api.denuncia.infra.exception.Erro;
import com.marqueserick.api.denuncia.model.Denuncia;
import com.marqueserick.api.denuncia.model.Denunciante;
import com.marqueserick.api.denuncia.model.Ponto;
import com.marqueserick.api.denuncia.repository.DenunciaRepository;
import com.marqueserick.api.denuncia.repository.DenuncianteRepository;
import com.marqueserick.api.denuncia.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.marqueserick.api.denuncia.utils.Util.enderecoValido;
import static com.marqueserick.api.denuncia.utils.Util.validarCpf;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private DenuncianteRepository denuncianteRepository;

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public DenunciaDto novaDenuncia(DenunciaDto denunciaDto) {
        Ponto ponto = buscarPonto(denunciaDto.getLatitude(), denunciaDto.getLongitude());
        Denunciante denunciante = buscarDenunciante(denunciaDto.getDenunciante());

        Denuncia denuncia = new Denuncia();
        denuncia.setTitulo(denunciaDto.getDenuncia().getTitulo());
        denuncia.setDescricao(denunciaDto.getDenuncia().getDescricao());
        denuncia.setPonto(ponto);
        denuncia.setDenunciante(denunciante);
        denunciaRepository.save(denuncia);

        Endereco endereco = buscarEndereco(denunciaDto.getLatitude(), denunciaDto.getLongitude());
        return new DenunciaDto(denuncia, endereco);
    }

    private Endereco buscarEndereco(Double latitude, Double longitude){
        return enderecoService.buscarEndereco(latitude, longitude);
    }

    private Ponto buscarPonto(Double latitude, Double longitude){
        List<Ponto> ponto = pontoRepository.findByLatitudeAndLongitude(latitude,longitude);
        if(!ponto.isEmpty()) return ponto.get(0);

        if(!enderecoValido(buscarEndereco(latitude, longitude))) throw new Erro("Endereço não encontrado para essa localidade",
                "02", HttpStatus.NOT_FOUND);

        Ponto p = new Ponto(latitude, longitude);
        pontoRepository.save(p);
        return p;
    }

    private Denunciante buscarDenunciante(DenuncianteDto denuncianteDto){
        String cpf = validarCpf(denuncianteDto.getCpf());
        Optional<Denunciante> denunciante = denuncianteRepository.findByCpf(cpf);
        if(denunciante.isPresent()) return denunciante.get();

        Denunciante d = new Denunciante(denuncianteDto.getNome(), cpf);
        denuncianteRepository.save(d);
        return d;
    }
}
