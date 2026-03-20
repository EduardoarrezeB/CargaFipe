package com.myfipe.demo.repository;

import com.myfipe.demo.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByCodigo(String codigo);
}