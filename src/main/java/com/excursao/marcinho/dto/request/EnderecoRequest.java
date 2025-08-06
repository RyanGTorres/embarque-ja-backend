package com.excursao.marcinho.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoRequest {
    @NotBlank(message = "Logradouro não deve estar em branco.")
    private String logradouro;
    @NotBlank(message = "Região não deve estar em branco.")
    private String regiao;
    @NotBlank(message = "Bairro não deve estar em branco.")
    private String bairro;
    @NotBlank(message = "Cidade não deve estar em branco.")
    private String cidade;
    @NotBlank(message = "CEP não deve estar em branco.")
    private String cep;
}
