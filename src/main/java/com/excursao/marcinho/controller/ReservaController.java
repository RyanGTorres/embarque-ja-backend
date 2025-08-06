package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.request.ReservaRequest;
import com.excursao.marcinho.dto.response.AssentoView;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponse> reservarAssento(@Valid @RequestBody ReservaRequest reservaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.reservaAssento(reservaRequest));
    }

    @GetMapping("/excursao/{id}")
    public ResponseEntity<List<ReservaResponse>> reservasPorExcursao(@PathVariable long id){
        return ResponseEntity.ok(reservaService.findAllReservaByOnibusExcursaoId(id));
    }

//    @GetMapping("/{excursaoId}")
//    public ResponseEntity<List<AssentoView>> mapaDeAssentos(@PathVariable Long excursaoId){
//        return ResponseEntity.ok(reservaService.listarAssentos(excursaoId));
//    }
}
