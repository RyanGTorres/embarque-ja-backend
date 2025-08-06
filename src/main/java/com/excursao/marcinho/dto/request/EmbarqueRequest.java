package com.excursao.marcinho.dto.request;

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
    @NotBlank(message = "Local de Embarque não deve estar em branco.")
    private String localEmbarque;
    @NotBlank(message = "Horario de embarque não deve estar em branco.")
    private String horarioEmbarque;
}
