package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.enums.StatusViagem;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcursaoResponse {
    private Long id;
    private String hotel;
    private StatusViagem statusViagem;
    private String origem;
    private String destino;
    private LocalDate dataSaida;
    private LocalDate dataRetorno;
    private List<EmbarqueResponse> embarques;
}

