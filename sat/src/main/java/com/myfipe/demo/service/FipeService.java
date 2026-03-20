package com.myfipe.demo.service;

import com.myfipe.demo.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FipeService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<MarcaDTO> buscarMarcas(String tipo) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + tipo + "/brands";
        return Arrays.asList(restTemplate.getForObject(url, MarcaDTO[].class));
    }

    public List<ModeloDTO> buscarModelos(String tipo, String marcaId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + tipo + "/brands/" + marcaId + "/models";
        return Arrays.asList(restTemplate.getForObject(url, ModeloDTO[].class));
    }

    public List<AnoDTO> buscarAnos(String tipo, String marcaId, String modeloId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + tipo + "/brands/" + marcaId + "/models/" + modeloId + "/years";
        return Arrays.asList(restTemplate.getForObject(url, AnoDTO[].class));
    }

    // Este não é uma lista pois, ao buscar da forma que a URL está setada retorna apenas 1 elemento.
    public DadosDTO buscarDados(String tipo, String marcaId, String modeloId, String anoId){
        String url = "https://fipe.parallelum.com.br/api/v2/" + tipo + "/brands/" + marcaId + "/models/" + modeloId + "/years/" + anoId;
        return restTemplate.getForObject(url, DadosDTO.class);
    }
}
