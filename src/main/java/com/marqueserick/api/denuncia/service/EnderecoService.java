package com.marqueserick.api.denuncia.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.marqueserick.api.denuncia.dto.Endereco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EnderecoService {

    @Value("${endereco.service.url}")
    private String url;

    @Value("${endereco.service.key}")
    private String key;

    @Cacheable("endereco")
    public Endereco buscarEndereco(Double latitude, Double longitude){
        String urlGet = criarUrl(latitude, longitude);
        Endereco endereco = null;

        try{
            URL url = new URL(urlGet);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.connect();

            if(conexao.getResponseCode() != HttpStatus.OK.value()) throw new RuntimeException();

            JsonParser jp = new JsonParser();
            JsonElement jsonElement = jp.parse(new InputStreamReader((InputStream) conexao.getContent()));
            JsonArray results = (JsonArray) jsonElement.getAsJsonObject().get("results");
            JsonArray locations = (JsonArray) results.get(0).getAsJsonObject().get("locations");
            endereco = new Endereco(locations.get(0).getAsJsonObject());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    private String criarUrl(Double latitude, double longitude){
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("?key=")
                .append(key).append("&location=")
                .append(latitude).append(",").append(longitude);
        return sb.toString();
    }
}
