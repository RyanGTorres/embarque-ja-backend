package com.excursao.marcinho.mapper;



import com.excursao.marcinho.dto.request.EnderecoRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.dto.response.EnderecoResponse;
import com.excursao.marcinho.entity.Cliente;
import com.excursao.marcinho.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public Endereco toEntity (EnderecoRequest enderecoRequest, Cliente cliente){
        return Endereco.builder()
                .logradouro(enderecoRequest.logradouro())
                .regiao(enderecoRequest.regiao())
                .bairro(enderecoRequest.bairro())
                .cidade(enderecoRequest.cidade())
                .cep(enderecoRequest.cep())
                .cliente(cliente)
                .build();
    }

    public EnderecoResponse toResponse(Endereco endereco){
        return new EnderecoResponse(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getRegiao(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getCep(),
                toClienteResponse(endereco.getCliente())
        );
    }

    private ClienteResponse toClienteResponse(Cliente cliente){
        if (cliente == null) return null;

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

