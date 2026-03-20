package com.myfipe.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ano {

    @Id
    @GeneratedValue
    private Long id;

    private String codigo;
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }


}
