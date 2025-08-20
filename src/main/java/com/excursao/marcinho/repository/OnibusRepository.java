package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnibusRepository extends JpaRepository<Onibus, Long> {
    boolean existsByModeloAndEmpresa(String modelo, String Empresa);
}
