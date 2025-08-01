package com.excursao.marcinho.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RoteiroRequest {
    private String origem;
    private String destino;
    private String horaRetorno;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataSaida;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRetorno;
    private List<Long> embarquesIds;
}
