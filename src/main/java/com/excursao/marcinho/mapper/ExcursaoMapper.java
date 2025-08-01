package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.entity.Excursao;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoteiroMapper.class)
public interface ExcursaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roteiro", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    Excursao toEntity (ExcursaoRequest excursaoRequest);

    @Mapping(target = "roteiro", source = "roteiro")
    ExcursaoResponse toResponse(Excursao excursao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roteiro", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest (ExcursaoRequest excursaoRequest, @MappingTarget Excursao excursao);

}
