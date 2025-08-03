package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.ExcursaoOnibus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExcursaoOnibusRepository extends JpaRepository<ExcursaoOnibus, Long> {

    Optional<ExcursaoOnibus> findByExcursaoId(Long id);
}
