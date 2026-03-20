package com.myfipe.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarcaDTO {

    @JsonProperty("code")
    private String codigo;
    @JsonProperty("name")
    private String nome;

    public MarcaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}