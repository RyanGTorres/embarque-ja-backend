package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Onibus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcursaoOnibusRequest {
    private Long onibus;
    private Long excursao;
}
