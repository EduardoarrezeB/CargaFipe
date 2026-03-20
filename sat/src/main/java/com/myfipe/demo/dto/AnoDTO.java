package com.myfipe.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnoDTO {

    @JsonProperty("code")
    private String codigo;
    @JsonProperty("name")
    private String nome;

    public AnoDTO() {

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
