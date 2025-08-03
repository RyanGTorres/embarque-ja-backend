package com.excursao.marcinho.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbarqueResponse {
    private Long id;
    private String localEmbarque;
    private String horarioEmbarque;
}
