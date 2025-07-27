package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.dto.request.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String celular;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
}
