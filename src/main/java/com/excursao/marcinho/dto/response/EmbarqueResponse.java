package com.excursao.marcinho.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados de resposta do embarque")
public class EmbarqueResponse {
    @Schema(description = "ID único do Embarque", example = "1")
    private Long id;
    @Schema(description = "Local do Embarque", example = "Shopping centro")
    private String localEmbarque;
    @Schema(description = "Horario do Embarque", example = "19:30 até 19:50")
    private String horarioEmbarque;
}
