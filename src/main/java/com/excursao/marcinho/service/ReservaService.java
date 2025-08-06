package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ReservaRequest;
import com.excursao.marcinho.dto.response.AssentoView;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.entity.Cliente;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import com.excursao.marcinho.entity.Reserva;
import com.excursao.marcinho.enums.StatusAssento;
import com.excursao.marcinho.exceptions.BusinessException;
import com.excursao.marcinho.exceptions.notfound.ClienteNotFoundException;
import com.excursao.marcinho.exceptions.notfound.ExcursaoOnibusNotFoundException;
import com.excursao.marcinho.exceptions.notfound.NotFoundException;
import com.excursao.marcinho.mapper.ReservaMapper;
import com.excursao.marcinho.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ExcursaoOnibusRepository excursaoOnibusRepository;
    private final ClienteRepository clienteRepository;
    private final ReservaMapper mapper;


    public ReservaResponse reservaAssento(ReservaRequest request) {

        ExcursaoOnibus excursaoOnibus = excursaoOnibusRepository.findById(request.getExcursaoId())
                .orElseThrow(ExcursaoOnibusNotFoundException::new);

        Integer totalAssentos = excursaoOnibus.getOnibus().getTotalAssentos();

        if (request.getNumeroAssento() < 1 || request.getNumeroAssento() > totalAssentos) {
            throw new BusinessException("O assento digitado não é válido! O valor máximo de assento é: " + totalAssentos + " assentos");
        }

        boolean verificarAssento = reservaRepository
                .existsByNumeroAssentoAndExcursaoOnibusIdAndStatusAssentoNot(
                        request.getNumeroAssento(), request.getExcursaoId(), StatusAssento.LIVRE);

        if (verificarAssento) {
            throw new BusinessException("Assento " + request.getNumeroAssento() + " já está ocupado nesta excursão");
        }

        boolean clienteJaTemReserva = reservaRepository
                .existsByClienteIdAndExcursaoOnibusIdAndStatusAssentoNot(
                        request.getClienteId(), request.getExcursaoId(), StatusAssento.LIVRE);


        if (clienteJaTemReserva) {
            throw new BusinessException("O cliente já tem cadastro nesta viagem!");
        }

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(ClienteNotFoundException::new);

        Reserva reserva = new Reserva();
        reserva.setExcursaoOnibus(excursaoOnibus);
        reserva.setCliente(cliente);
        reserva.setNumeroAssento(request.getNumeroAssento());
        reserva.setStatusAssento(StatusAssento.RESERVADO);
        reserva.setCriadaEm(LocalDateTime.now());

        Reserva salva = reservaRepository.save(reserva);

        return mapper.toResponse(salva);
    }


    public List<ReservaResponse> findAllReservaByOnibusExcursaoId (Long id){
           List<Reserva> reservaList = reservaRepository.findByExcursaoOnibusId(id);
           return mapper.toListResponse(reservaList);
    }

//    public List<AssentoView> listarAssentos (Long excursaoId){
//
//        ExcursaoOnibus excursaoOnibus = excursaoOnibusRepository.findById(excursaoId)
//                .orElseThrow(ExcursaoOnibusNotFoundException::new);
//
//        Integer totalAssentos = excursaoOnibus.getOnibus().getTotalAssentos();
//
//        List<Reserva> reservaList = reservaRepository.findByExcursaoOnibusIdAndStatusAssentoNot(
//                excursaoId, StatusAssento.LIVRE);
//
//    }

}
