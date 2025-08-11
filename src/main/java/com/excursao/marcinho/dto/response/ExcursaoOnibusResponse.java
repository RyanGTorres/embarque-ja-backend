package com.excursao.marcinho.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Dados de resposta do Excursão com Onibus")
public class ExcursaoOnibusResponse {
    @Schema(description = "ID único do Excursão com Onibus", example = "1")
    private Long id;

    @Schema(description = "ID único do Onibus", example = "1")
    private OnibusResponse onibus;

    @Schema(description = "ID único da Excursão", example = "3")
    private ExcursaoResponse excursao;
}
