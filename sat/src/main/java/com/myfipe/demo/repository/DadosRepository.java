package com.myfipe.demo.repository;

import com.myfipe.demo.entity.Dados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DadosRepository extends JpaRepository<Dados, Long> {
    @Override
    Optional<Dados> findById(Long aLong);
}
