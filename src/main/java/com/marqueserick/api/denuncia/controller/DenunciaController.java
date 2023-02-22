package com.marqueserick.api.denuncia.controller;

import com.marqueserick.api.denuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService service;


}
