package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
