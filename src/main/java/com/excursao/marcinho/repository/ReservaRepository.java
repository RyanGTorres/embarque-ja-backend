package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Reserva;
import com.excursao.marcinho.enums.StatusAssento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByExcursaoOnibus_Excursao_Id(Long excursaoId);
    Optional<Reserva> findByNumeroAssentoAndExcursaoOnibus_Excursao_IdAndStatusAssentoNot(
            Integer numeroAssento, Long excursaoId, StatusAssento status);
    boolean existsByNumeroAssentoAndExcursaoOnibusIdAndStatusAssentoNot(Integer numeroAssento, Long excursaoId, StatusAssento status);
    boolean existsByClienteIdAndExcursaoOnibusIdAndStatusAssentoNot(Long clienteId, Long excursaoId, StatusAssento status);
}
