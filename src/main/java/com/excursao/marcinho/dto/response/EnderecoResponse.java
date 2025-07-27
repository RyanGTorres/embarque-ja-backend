package com.excursao.marcinho.dto.request;

import com.excursao.marcinho.entity.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoRequest {
    private String logradouro;
    private String regiao;
    private String bairro;
    private String cidade;
    private String cep;
}
