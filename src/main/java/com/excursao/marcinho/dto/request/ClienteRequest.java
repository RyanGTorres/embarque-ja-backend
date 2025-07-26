package com.excursao.marcinho.dto.request;

import java.time.LocalDate;

public record ClienteRequest(
        String nome,
        String rg,
        String cpf,
        String email,
        String celular,
        LocalDate dataNascimento
) {
}
