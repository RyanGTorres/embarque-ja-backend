package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.enums.StatusViagem;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcursaoRequest {

    @Schema(type = "string", description = "Compo de preenchimento da Origem", example = "Belo Horizonte" )
    @NotBlank(message = "Origem não deve estar em branco.")
    private String origem;

    @Schema(type = "string", description = "Compo de preenchimento de Destino", example = "Cabo Frio" )
    @NotBlank(message = "Destino não deve estar em branco.")
    private String destino;

    @Schema(type = "string", description = "Compo de preenchimento da Data de Saída", example = "24/05/2025" )
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de Saída não deve estar em branco.")
    private LocalDate dataSaida;

    @Schema(type = "string", description = "Compo de preenchimento da Data de Retorno", example = "27/05/2025" )
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de Retorno não deve estar em branco.")
    private LocalDate dataRetorno;
    private List<Long> embarquesIds;
    private List<Long> hoteisIds;
}
