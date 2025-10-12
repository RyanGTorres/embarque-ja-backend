package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
