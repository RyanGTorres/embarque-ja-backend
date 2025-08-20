package com.excursao.marcinho.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnibusRequest {
    @Schema(type = "string", description = "Campo de preenchimento da Modelo", example = "Marcopolo G7" )
    @NotBlank(message = "Modelo não deve estar em branco.")
    private String modelo;
    @Schema(type = "string", description = "Campo de preenchimento da Empresa", example = "Mar e Praia" )
    @NotBlank(message = "Empresa não deve estar em branco.")
    private String empresa;

    @Schema(type = "string", description = "Campo de preenchimento do tipo de assento", example = "Leito-Total" )
    @NotBlank(message = "O tipo de assento não deve estar em branco.")
    private String tipoAssento;

    @Schema(type = "string", description = "Campo de preenchimento de quantidade de andares", example = "2 Andar" )
    @NotBlank(message = "A quantidade de andares não deve estar em branco.")
    private String quantidadeAndares;

    @Schema(type = "integer", description = "Assento do total do Onibus", example = "64" )
    @NotNull(message = "Total de assento não deve ser nulo")
    @Positive
    private Integer totalAssentos;
}
