package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Embarque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbarqueRepository extends JpaRepository<Embarque , Long> {
}
