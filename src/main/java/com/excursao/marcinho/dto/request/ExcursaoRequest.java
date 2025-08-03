package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.enums.StatusViagem;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcursaoRequest {
    private String hotel;
    private String origem;
    private String destino;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRetorno;
    private StatusViagem statusViagem;
    private List<Long> embarquesIds;
}
