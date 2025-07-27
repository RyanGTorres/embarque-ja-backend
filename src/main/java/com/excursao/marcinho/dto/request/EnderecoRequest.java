package com.excursao.marcinho.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoRequest {
    private String logradouro;
    private String regiao;
    private String bairro;
    private String cidade;
    private String cep;
}
