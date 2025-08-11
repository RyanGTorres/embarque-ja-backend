package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ReservaRequest;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
@Tag(name = "Reserva", description = "Recurso responsavel pelo gerencimaneto de reserva")
public class ReservaController {
    private final ReservaService reservaService;

    @Operation(summary = "Reservar assento",
            description = "Realiza a reserva de um assento específico em uma excursão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reserva realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou regra de negócio violada"),
            @ApiResponse(responseCode = "404", description = "Cliente ou excursão não encontrados")
    })
    @PostMapping
    public ResponseEntity<ReservaResponse> reservarAssento(
            @Valid @RequestBody ReservaRequest reservaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservaService.reservaAssento(reservaRequest));
    }

    @Operation(summary = "Listar reservas por excursão",
            description = "Retorna todas as reservas de uma excursão específica")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de reservas retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Excursão não encontrada")
    })
    @GetMapping("/excursao/{id}")
    public ResponseEntity<List<ReservaResponse>> reservasPorExcursao(@PathVariable long id) {
        return ResponseEntity.ok(reservaService.findAllReservaByOnibusExcursaoId(id));
    }

    @Operation(summary = "Listar reservas canceladas por excursão",
            description = "Retorna todas as reservas canceladas de uma excursão específica")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de reservas canceladas retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Excursão não encontrada")
    })
    @GetMapping("/excursao/canceladas/{id}")
    public ResponseEntity<List<ReservaResponse>> reservasPorExcursaoCancelada(@PathVariable long id) {
        return ResponseEntity.ok(reservaService.findAllReservaCanceled(id));
    }

    @Operation(summary = "Cancelar reserva",
            description = "Cancela uma reserva existente de um assento em uma excursão")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Reserva cancelada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    @DeleteMapping
    public ResponseEntity<Void> cancelarReserva(
            @RequestParam Long excursaoId,
            @RequestParam Integer numeroAssento) {
        reservaService.cancelarReserva(excursaoId, numeroAssento);
        return ResponseEntity.noContent().build();
    }
}

