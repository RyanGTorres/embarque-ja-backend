package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.entity.Excursao;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmbarqueMapper.class)
public interface ExcursaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaoOnibus", ignore = true)
    @Mapping(target = "embarques", ignore = true)
    Excursao toEntity (ExcursaoRequest excursaoRequest);

    @Mapping(target = "embarques", source = "embarques")
    ExcursaoResponse toResponse(Excursao excursao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaoOnibus", ignore = true)
    @Mapping(target = "embarques", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest (ExcursaoRequest excursaoRequest, @MappingTarget Excursao excursao);

}
