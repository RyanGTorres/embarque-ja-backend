package com.excursao.marcinho.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoRequest {
    @Schema(type = "string", description = "Logradou onde o cliente reside", example = "Rua das flores")
    @NotBlank(message = "Logradouro não deve estar em branco.")
    private String logradouro;

    @Schema(type = "string", description = "Região onde o cliente reside", example = "(Justinopolis)")
    @NotBlank(message = "Região não deve estar em branco.")
    private String regiao;

    @Schema(type = "string", description = "Bairro onde o cliente reside", example = "Santana")
    @NotBlank(message = "Bairro não deve estar em branco.")
    private String bairro;

    @Schema(type = "string", description = "Cidade onde o cliente reside", example = "Belo Horizonte")
    @NotBlank(message = "Cidade não deve estar em branco.")
    private String cidade;

    @Schema(type = "string", description = "CEP onde o cliente reside", example = "33001-023")
    @NotBlank(message = "CEP não deve estar em branco.")
    private String cep;
}
