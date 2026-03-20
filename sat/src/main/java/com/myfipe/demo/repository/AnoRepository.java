package com.myfipe.demo.repository;

import com.myfipe.demo.entity.Ano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnoRepository extends JpaRepository<Ano, Long> {

    Optional<Ano> findByCodigo(String codigo);
}