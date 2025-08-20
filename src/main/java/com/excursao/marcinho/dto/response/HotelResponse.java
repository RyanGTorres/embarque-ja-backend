package com.excursao.marcinho.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados de resposta de Hotel")
public class HotelResponse {
    @Schema(description = "ID único do hotel", example = "1")
    private Long id;

    @Schema(description = "Nome do Hotel", example = "Hotel Bela Vista")
    private String hotel;
}
