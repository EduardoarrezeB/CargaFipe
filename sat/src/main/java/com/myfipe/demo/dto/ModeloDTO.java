package com.myfipe.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModeloDTO {

    @JsonProperty("code")
    private String codigo;
    @JsonProperty("name")
    private String nome;

    public ModeloDTO() {

    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
