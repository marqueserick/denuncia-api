package com.marqueserick.api.denuncia.service;

import com.marqueserick.api.denuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;
}
