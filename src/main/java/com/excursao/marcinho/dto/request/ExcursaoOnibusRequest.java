package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Onibus;
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
public class ExcursaoOnibusRequest {
    @NotNull(message = "O ID de onibus não deve estar em branco.")
    @Positive
    private Long onibus;
    @NotNull(message = "O ID de excursao não deve estar em branco.")
    @Positive
    private Long excursao;
}
