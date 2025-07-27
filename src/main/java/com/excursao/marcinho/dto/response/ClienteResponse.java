package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.entity.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String celular;
    private LocalDate dataNascimento;
    private EnderecoRequest endereco;
}
