package com.excursao.marcinho.dto.response;

import java.time.LocalDate;

public record ClienteResponse(
        Long id,
        String nome,
        String rg,
        String cpf,
        String email,
        String celular,
        LocalDate dataNascimento
) {
}
