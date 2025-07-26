package com.excursao.marcinho.dto.response;

public record EnderecoResponse(
        Long id,
        String logradouro,
        String regiao,
        String bairro,
        String cidade,
        String cep,
        ClienteResponse clienteResponse
) {
}
