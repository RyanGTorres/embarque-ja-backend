package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.dto.request.OnibusRequest;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Onibus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcursaoOnibusResponse {
    private Long id;
    private OnibusResponse onibus;
    private ExcursaoResponse excursao;
}
