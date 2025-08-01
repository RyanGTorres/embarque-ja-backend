package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.entity.Embarque;
import com.excursao.marcinho.entity.Excursao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoteiroResponse {
    private Long id;
    private String origem;
    private String destino;
    private String horaRetorno;
    private LocalDate dataSaida;
    private LocalDate dataRetorno;
    private List<EmbarqueResponse> embarques;
}
