package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.enums.StatusViagem;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotBlank(message = "Hotel não deve estar em branco.")
    private String hotel;
    @NotBlank(message = "Origem não deve estar em branco.")
    private String origem;
    @NotBlank(message = "Destino não deve estar em branco.")
    private String destino;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data de Saída não deve estar em branco.")
    private LocalDate dataSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data de Retorno não deve estar em branco.")
    private LocalDate dataRetorno;
    private StatusViagem statusViagem;
    private List<Long> embarquesIds;
}
