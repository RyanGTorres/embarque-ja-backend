package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ReservaRequest;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.entity.Cliente;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import com.excursao.marcinho.entity.Reserva;
import com.excursao.marcinho.enums.StatusAssento;
import com.excursao.marcinho.mapper.ReservaMapper;
import com.excursao.marcinho.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ExcursaoOnibusRepository excursaoOnibusRepository;
    private final ClienteRepository clienteRepository;
    private final ReservaMapper mapper;


    public ReservaResponse reservaAssento(ReservaRequest request) {

        ExcursaoOnibus excursaoOnibus = excursaoOnibusRepository.findById(request.getExcursaoId())
                .orElseThrow(() -> new RuntimeException("Excursão não encontrada! Id: " + request.getExcursaoId()));

        Integer totalAssentos = excursaoOnibus.getOnibus().getTotalAssentos();

        if (request.getNumeroAssento() < 1 || request.getNumeroAssento() > totalAssentos) {
            throw new RuntimeException("O assento digitado não é válido! O valor máximo de assento é: " + totalAssentos + " assentos");
        }

        boolean verificarAssento = reservaRepository
                .existsByNumeroAssentoAndExcursaoOnibusIdAndStatusAssentoNot(
                        request.getNumeroAssento(), request.getExcursaoId(), StatusAssento.LIVRE);

        if (verificarAssento) {
            throw new RuntimeException("Assento " + request.getNumeroAssento() + " já está ocupado nesta excursão");
        }

        boolean clienteJaTemReserva = reservaRepository
                .existsByClienteIdAndExcursaoOnibusIdAndStatusAssentoNot(
                        request.getClienteId(), request.getExcursaoId(), StatusAssento.LIVRE);


        if (clienteJaTemReserva) {
            throw new RuntimeException("O cliente já tem cadastro nesta viagem!");
        }

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Não existe este cliente"));

        Reserva reserva = new Reserva();
        reserva.setExcursaoOnibus(excursaoOnibus);
        reserva.setCliente(cliente);
        reserva.setNumeroAssento(request.getNumeroAssento());
        reserva.setStatusAssento(StatusAssento.RESERVADO);
        reserva.setCriadaEm(LocalDateTime.now());

        Reserva salva = reservaRepository.save(reserva);

        return mapper.toResponse(salva);
    }



}
