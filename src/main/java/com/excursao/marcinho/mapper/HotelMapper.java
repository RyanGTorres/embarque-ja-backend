package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.request.HotelRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;
import com.excursao.marcinho.dto.response.HotelResponse;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import com.excursao.marcinho.entity.Hotel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaos", ignore = true)
    Hotel toEntity (HotelRequest hotelRequest);

    HotelResponse toResponse (Hotel hotel);

    List<HotelResponse> toListResponse (List<Hotel> hotelList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "excursaos", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEnityFromRequest (HotelRequest hotelRequest, @MappingTarget Hotel hotel);
}
