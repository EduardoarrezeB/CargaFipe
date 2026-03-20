package com.myfipe.demo.entity;

import jakarta.persistence.*;

@Entity
public class Modelo {

    @Id
    @GeneratedValue
    private Long id;

    private String codigo;
    private String nome;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
