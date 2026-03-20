package com.myfipe.demo.entity;

import jakarta.persistence.*;

@Entity
public class Dados {

    @Id
    @GeneratedValue
    private String id;

    private Integer tipoVeiculo;
    private String precoVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoModelo;
    private String tipoGasolina;
    private String codigoFipe;
    private String refMes;
    private String acronimoGasolina;

    @ManyToOne
    @JoinColumn(name = "ano_id")
    private Ano ano;

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setPrecoVeiculo(String precoVeiculo) {
        this.precoVeiculo = precoVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public void setRefMes(String refMes) {
        this.refMes = refMes;
    }

    public void setAcronimoGasolina(String acronimoGasolina) {
        this.acronimoGasolina = acronimoGasolina;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
    }
}
