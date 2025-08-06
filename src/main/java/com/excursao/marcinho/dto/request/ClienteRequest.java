package com.excursao.marcinho.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {
    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;
    @NotBlank(message = "RG não deve estar em branco.")
    private String rg;
    @NotBlank (message = "CPF não deve estar em branco.")
    @CPF(message = "O CPF é invalido.")
    private String cpf;
    @NotBlank(message = "Email não deve estar em branco.")
    @Email(message = "Email é invalido")
    private String email;
    @NotBlank(message = "Celular não deve estar em branco.")
    private String celular;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de nascimento não deve estar em branco.")
    private LocalDate dataNascimento;
    private EnderecoRequest endereco;
}
