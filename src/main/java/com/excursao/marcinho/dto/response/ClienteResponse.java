package com.excursao.marcinho.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Dados de resposta do cliente")
public class ClienteResponse {

    @Schema(description = "ID único do cliente", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente", example = "João da Silva")
    private String nome;

    @Schema(description = "Número do RG", example = "MG 0002100")
    private String rg;

    @Schema(description = "Número do CPF", example = "000.111.222-33")
    private String cpf;

    @Schema(description = "Email do cliente", example = "joao@gmail.com")
    private String email;

    @Schema(description = "Celular do cliente", example = "(31) 00000-1111")
    private String celular;

    @Schema(description = "Data de nascimento do cliente", example = "01/02/2003")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Schema(description = "Informações do endereço do cliente")
    private EnderecoResponse endereco;
}
