package com.excursao.marcinho.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {

    @Schema(type = "string", description = "Nome do cliente", example = "João da Silva")
    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;

    @Schema(type = "string", description = "Numero do RG", example = "MG 0002100")
    @NotBlank(message = "RG não deve estar em branco.")
    private String rg;

    @Schema(type = "string", description = "Numero do CPF", example = "000.111.222-33")
    @NotBlank (message = "CPF não deve estar em branco.")
    @CPF(message = "O CPF é invalido.")
    private String cpf;

    @Schema(type = "string", description = "Campo do Email", example = "joao@gmail.com")
    @NotBlank(message = "Email não deve estar em branco.")
    @Email(message = "Email é invalido")
    private String email;

    @Schema(type = "string", description = "Campo do celular", example = "(31) 00000-1111")
    @NotBlank(message = "Celular não deve estar em branco.")
    private String celular;


    @Schema(type = "string", description = "Data de nascimento do cliente", example = "01/02/2003")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de nascimento não deve estar em branco.")
    private LocalDate dataNascimento;

    @Schema(type = "object", description = "Informaçoes do endereco de cliente")
    private EnderecoRequest endereco;
}
