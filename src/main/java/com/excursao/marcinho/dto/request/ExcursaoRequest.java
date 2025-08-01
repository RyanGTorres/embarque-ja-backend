package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.enums.StatusViagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcursaoRequest {
    private String hotel;
    private StatusViagem statusViagem;
    private Long roteiroId;
}
