package com.marqueserick.api.denuncia.utils;

import com.marqueserick.api.denuncia.dto.Endereco;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

    public static String converterParaString(BufferedReader br) throws IOException {
        String json="", linha;
        while((linha = br.readLine()) != null){
            json += linha;
        }

        return json;
    }

    public static boolean enderecoValido(Endereco endereco){
        return endereco.getPais() != null && !endereco.getPais().isEmpty()
                && endereco.getEstado() != null && !endereco.getEstado().isEmpty()
                && endereco.getCidade() != null && !endereco.getCidade().isEmpty();
    }
}
