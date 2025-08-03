package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.request.ReservaRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponse> reservarAssento(@RequestBody ReservaRequest reservaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.reservaAssento(reservaRequest));
    }
}
