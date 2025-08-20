package com.excursao.marcinho.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Dados de resposta do Endereço")
public class EnderecoResponse {
    @Schema(description = "ID único do cliente", example = "1")
    private Long id;
    @Schema(description = "Logradouro do cliente", example = "Rua das flores")
    private String logradouro;

    @Schema(description = "Numero da casa onde o cliente reside", example = "45B")
    private String numero;

    @Schema(description = "Estado onde o cliente reside", example = "MG")
    private String estado;

    @Schema(description = "Bairro do cliente", example = "Santana")
    private String bairro;
    @Schema(description = "Cidade do cliente", example = "Belo Horizonte")
    private String cidade;
    @Schema(description = "CEP do cliente", example = "33001-023")
    private String cep;
}
