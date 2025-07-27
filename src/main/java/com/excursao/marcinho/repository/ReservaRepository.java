package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
