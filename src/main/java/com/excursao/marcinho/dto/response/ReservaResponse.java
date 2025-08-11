package com.excursao.marcinho.dto.response;


import com.excursao.marcinho.enums.StatusAssento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados de resposta de Reserva")
public class ReservaResponse {
    @Schema(description = "ID único da Reserva", example = "1")
    private Long id;
    @Schema(description = "Nome do cliente", example = "João da Silva")
    private String nomeCliente;
    @Schema(description = "CPF do cliente", example = "000.111.222-33")
    private String cpfCliente;
    @Schema(description = "Status do Assento do cliente", example = "RESERVADO")
    private StatusAssento statusAssento;
    @Schema(description = "Status do Assento do cliente", example = "47")
    private Integer numeroAssento;
    @Schema(description = "Data de criação da reserva", example = "2025-08-08 21:44:30.485")
    private LocalDateTime criadaEm;
}
