package com.marqueserick.api.denuncia.utils;

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
}
