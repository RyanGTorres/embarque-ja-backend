package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ClienteRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.entity.Cliente;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "endereco.cliente", ignore = true)
    Cliente toEntity (ClienteRequest clienteRequest);

    ClienteResponse toResponse(Cliente cliente);

    List<ClienteResponse> toListResponse(List<Cliente> cliente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "endereco.cliente", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResponseFromRequest(ClienteRequest clienteRequest, @MappingTarget Cliente cliente);

    @AfterMapping
    default void linkEnderecoToCliente(@MappingTarget Cliente cliente){
        if (cliente.getEndereco() != null){
            cliente.getEndereco().setCliente(cliente);
        }
    }
}
