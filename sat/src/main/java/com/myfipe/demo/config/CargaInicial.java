package com.myfipe.demo.config;

import com.myfipe.demo.service.CargaFipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private CargaFipeService cfs;

    @Override
    public void run(String... args) throws Exception {
        // chamada da API Fipe direta
        cfs.executarCarga();
        // salva no banco para popular
    }
}
