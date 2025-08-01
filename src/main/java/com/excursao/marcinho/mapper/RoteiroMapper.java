package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.RoteiroRequest;
import com.excursao.marcinho.dto.response.RoteiroResponse;
import com.excursao.marcinho.entity.Roteiro;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = EmbarqueMapper.class)
public interface RoteiroMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursao", ignore = true)
    @Mapping(target = "embarques", ignore = true)
    Roteiro toEntity(RoteiroRequest request);

    @Mapping(target = "embarques", source = "embarques")
    RoteiroResponse toResponse(Roteiro roteiro);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursao", ignore = true)
    @Mapping(target = "embarques", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest (RoteiroRequest request, @MappingTarget Roteiro roteiro);

}
