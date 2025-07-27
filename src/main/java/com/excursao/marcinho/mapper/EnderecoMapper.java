package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.EnderecoRequest;
import com.excursao.marcinho.dto.response.EnderecoResponse;
import com.excursao.marcinho.entity.Endereco;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    Endereco toEntity (EnderecoRequest enderecoRequest);

    EnderecoResponse toResponse(Endereco endereco);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(EnderecoRequest enderecoRequest, @MappingTarget Endereco endereco);
}
