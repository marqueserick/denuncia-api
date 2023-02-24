package com.marqueserick.api.denuncia.utils;

import com.marqueserick.api.denuncia.dto.Endereco;
import com.marqueserick.api.denuncia.infra.exception.Erro;
import org.springframework.http.HttpStatus;

public class Util {

    public static boolean enderecoValido(Endereco endereco){
        return endereco.getPais() != null && !endereco.getPais().isEmpty()
                && endereco.getEstado() != null && !endereco.getEstado().isEmpty()
                && endereco.getCidade() != null && !endereco.getCidade().isEmpty();
    }

    public static String validarCpf(String cpf){
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        try{
            Long l = Long.valueOf(cpf);
        }catch (Exception e){
            throw new Erro("CPF não válido","03", HttpStatus.BAD_REQUEST);
        }
        return cpf;
    }
}
