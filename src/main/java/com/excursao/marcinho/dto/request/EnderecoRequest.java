package com.excursao.marcinho.dto.request;

public record EnderecoRequest(
        String logradouro,
        String regiao,
        String bairro,
        String cidade,
        String cep,
        Long clienteID
) {
}
