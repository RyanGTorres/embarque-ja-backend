package com.excursao.marcinho.dto.response;


import com.excursao.marcinho.enums.StatusAssento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponse {
    private Long id;
    private String nomeCliente;
    private String cpfCliente;
    private StatusAssento statusAssento;
    private Integer numeroAssento;
    private LocalDateTime criadaEm;
}
