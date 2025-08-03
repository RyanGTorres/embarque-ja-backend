package com.excursao.marcinho.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnibusResponse {
    private Long id;

    private String modelo;

    private String empresa;

    private Integer totalAssentos;
}
