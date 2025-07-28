package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.OnibusRequest;
import com.excursao.marcinho.dto.response.OnibusResponse;
import com.excursao.marcinho.entity.Onibus;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OnibusMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    Onibus toEntity (OnibusRequest onibusRequest);

    OnibusResponse toResponse (Onibus onibus);

    List<OnibusResponse> toListResponse (List<Onibus> onibusList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromResponse(OnibusRequest onibusRequest, @MappingTarget Onibus onibus);
}
