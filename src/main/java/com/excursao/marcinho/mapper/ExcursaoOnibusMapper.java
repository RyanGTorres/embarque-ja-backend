package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ExcursaoOnibusMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "onibus", ignore = true)
    @Mapping(target = "excursao", ignore = true)
    ExcursaoOnibus toEntity (ExcursaoOnibusRequest excursaoOnibusRequest);

    ExcursaoOnibusResponse toResponse (ExcursaoOnibus excursaoOnibus);

    List<ExcursaoOnibusResponse> toListResponse (List<ExcursaoOnibus> excursaoOnibuses);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "onibus", ignore = true)
    @Mapping(target = "excursao", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEnityFromRequest (ExcursaoOnibusRequest excursaoOnibusRequest, @MappingTarget ExcursaoOnibus excursaoOnibus);
}
