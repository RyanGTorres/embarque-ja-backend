package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.enums.StatusViagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcursaoResponse {
    private Long id;
    private String hotel;
    private StatusViagem statusViagem;
    private RoteiroResponse roteiro;
}

