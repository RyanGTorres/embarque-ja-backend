package com.excursao.marcinho.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoResponse {
    private Long id;
    private String logradouro;
    private String regiao;
    private String bairro;
    private String cidade;
    private String cep;
}
