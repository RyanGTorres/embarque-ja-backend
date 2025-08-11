package com.excursao.marcinho.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbarqueRequest {
    @Schema(type = "string", description = "Campo do local de embarque", example = "Shopping centro")
    @NotBlank(message = "Local de Embarque não deve estar em branco.")
    private String localEmbarque;
    @Schema(type = "string", description = "Campo do horario do embarque", example = "19:30 até 19:50")
    @NotBlank(message = "Horario de embarque não deve estar em branco.")
    private String horarioEmbarque;
}
