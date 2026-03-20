package com.myfipe.demo.entity;

public enum TipoVeiculo {
    CARS("cars"),
    TRUCKS("trucks"),
    MOTORCYCLES("motorcycles");

    private final String path;

    TipoVeiculo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
