package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ClienteRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente toEntity(ClienteRequest clienteRequest){
        return Cliente.builder()
                .nome(clienteRequest.nome())
                .cpf(clienteRequest.cpf())
                .rg(clienteRequest.rg())
                .email(clienteRequest.email())
                .celular(clienteRequest.celular())
                .dataNascimento(clienteRequest.dataNascimento())
                .build();
    }

    public ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getRg(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getCelular(),
                cliente.getDataNascimento()
        );
    }

}
