package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Excursao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursaoRepository extends JpaRepository<Excursao, Long> {
}
