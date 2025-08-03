package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.EmbarqueRequest;
import com.excursao.marcinho.dto.response.EmbarqueResponse;
import com.excursao.marcinho.entity.Embarque;
import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmbarqueMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaos", ignore = true)
    Embarque toEntity(EmbarqueRequest embarqueRequest);

    EmbarqueResponse toResponse(Embarque embarque);

    List<EmbarqueResponse> toListResponse(List<Embarque> embarqueList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaos", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEnittyFromRequest(EmbarqueRequest embarqueRequest, @MappingTarget Embarque embarque);


}
