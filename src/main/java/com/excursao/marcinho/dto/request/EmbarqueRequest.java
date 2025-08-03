package com.excursao.marcinho.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbarqueRequest {
    private String localEmbarque;
    private String horarioEmbarque;
}
