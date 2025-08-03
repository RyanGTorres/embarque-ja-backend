package com.excursao.marcinho.dto.response;

import com.excursao.marcinho.enums.StatusAssento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AssentoView {
   private Integer numero;
   private String status;
   private String clienteNome;
   private Long clienteId;
   private StatusAssento statusAssento;

    public AssentoView(Integer numero) {
        this.numero = numero;
        this.status = "LIVRE";
        this.clienteNome = null;
        this.clienteId = null;
        this.statusAssento = null;
    }

    public AssentoView(Integer numero, String clienteNome, Long clienteId, StatusAssento statusAssento) {
        this.numero = numero;
        this.status = "OCUPADO";
        this.clienteNome = clienteNome;
        this.clienteId = clienteId;
        this.statusAssento = statusAssento;
    }
}

