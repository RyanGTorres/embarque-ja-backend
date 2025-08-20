package com.excursao.marcinho.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Dados de resposta de Onibus")
public class OnibusResponse {
    @Schema(description = "ID único de Onibus", example = "1")
    private Long id;

    @Schema(description = "Nome do modelo", example = "Marcopolo G7")
    private String modelo;

    @Schema(description = "Nome da empresa", example = "Mar e Praia")
    private String empresa;

    @Schema(description = "Tipo de Assentos", example = "Leito-Total")
    private String tipoAssento;

    @Schema(description = "Quantidade de Andares", example = "2 Andares")
    private String quantidadeAndares;

    @Schema(description = "Total de Assentos", example = "64")
    private Integer totalAssentos;
}
