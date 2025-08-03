package com.excursao.marcinho.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequest {
    private Long excursaoId;
    private Long clienteId;
    private Integer numeroAssento;
}
