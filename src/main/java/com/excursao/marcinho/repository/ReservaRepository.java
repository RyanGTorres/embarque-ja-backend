package com.excursao.marcinho.repository;
import com.excursao.marcinho.entity.Reserva;
import com.excursao.marcinho.enums.StatusAssento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByNumeroAssentoAndExcursaoOnibusIdAndStatusAssentoNot(Integer numeroAssento, Long excursaoId, StatusAssento status);
    boolean existsByClienteIdAndExcursaoOnibusIdAndStatusAssentoNot(Long clienteId, Long excursaoId, StatusAssento status);
    Optional<Reserva> findByNumeroAssentoAndExcursaoOnibusId(Long clienteId, Integer numeroAssento);
    List<Reserva> findByExcursaoOnibusIdAndStatusAssento (Long excursaoId, StatusAssento status);
}
