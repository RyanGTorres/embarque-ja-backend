package com.excursao.marcinho.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequest {
    @Schema(type = "long", description = "Campo de ID da Excursao", example = "2" )
    @NotNull(message = "O ID de onibus com excursão não deve estar em branco.")
    @Positive
    private Long excursaoId;
    @Schema(type = "long", description = "Campo de ID do Cliente", example = "10" )
    @NotNull(message = "O ID de cliente não deve estar em branco.")
    @Positive
    private Long clienteId;
    @Schema(type = "integer", description = "Campo de numero do assento", example = "47" )
    @NotNull(message = "Assento do cliente não deve estar em branco.")
    @Positive
    private Integer numeroAssento;
}
