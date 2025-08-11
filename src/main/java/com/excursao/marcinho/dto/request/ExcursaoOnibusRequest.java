package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Onibus;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(type = "long", description = "Campo para id do onibus", example = "1" )
    @NotNull(message = "O ID de onibus não deve estar em branco.")
    @Positive
    private Long onibus;

    @Schema(type = "long", description = "Campo para id de excursao", example = "3" )
    @NotNull(message = "O ID de excursao não deve estar em branco.")
    @Positive
    private Long excursao;
}
