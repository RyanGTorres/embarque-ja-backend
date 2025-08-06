package com.excursao.marcinho.repository;
import com.excursao.marcinho.entity.Reserva;
import com.excursao.marcinho.enums.StatusAssento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByNumeroAssentoAndExcursaoOnibusIdAndStatusAssentoNot(Integer numeroAssento, Long excursaoId, StatusAssento status);
    boolean existsByClienteIdAndExcursaoOnibusIdAndStatusAssentoNot(Long clienteId, Long excursaoId, StatusAssento status);
    List<Reserva> findByNumeroAssentoAndStatusAssentoNot(Integer numeroAssento,  StatusAssento status);
    List<Reserva> findByExcursaoOnibusIdAndStatusAssentoNot(Long excursaoId, StatusAssento status);
    List<Reserva> findByExcursaoOnibusId (Long excursaoId);
}
