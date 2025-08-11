package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.enums.StatusViagem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados de resposta da Excursão")
public class ExcursaoResponse {
    @Schema(description = "ID único da Excursão", example = "1")
    private Long id;
    @Schema(description = "Nome do Hotel", example = "Hotel Bela Vista")
    private String hotel;
    @Schema(description = "Status da Viagem", example = "DISPONIVEL")
    private StatusViagem statusViagem;
    @Schema(description = "Nome da origem", example = "Belo Horizonte")
    private String origem;
    @Schema(description = "Nome do destino", example = "Cabo Frio")
    private String destino;
    @Schema(description = "Data de saída", example = "24/05/2025")
    private LocalDate dataSaida;
    @Schema(description = "Data de retorno", example = "27/05/2025")
    private LocalDate dataRetorno;
    @Schema(description = "IDs de lista de embarques", example = "1,3")
    private List<EmbarqueResponse> embarques;
}

