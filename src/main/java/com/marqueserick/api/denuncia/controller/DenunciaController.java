package com.marqueserick.api.denuncia.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.marqueserick.api.denuncia.dto.DenunciaDto;
import com.marqueserick.api.denuncia.dto.Views;
import com.marqueserick.api.denuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @PostMapping
    public ResponseEntity<DenunciaDto> novaDenuncia(@RequestBody @JsonView(value = Views.Requisicao.class) DenunciaDto denuncia){
        return new ResponseEntity(service.novaDenuncia(denuncia), HttpStatus.CREATED);
    }


}
