package com.excursao.marcinho.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequest {
    @Schema(type = "string",description = "Nome do Hotel", example = "Hotel Bela Vista")
    private String hotel;
}
