package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.HotelRequest;
import com.excursao.marcinho.dto.response.HotelResponse;
import com.excursao.marcinho.entity.Hotel;
import com.excursao.marcinho.exceptions.conflict.ConflictException;
import com.excursao.marcinho.exceptions.notfound.EmbarqueNotFoundException;
import com.excursao.marcinho.exceptions.notfound.HotelNotFoundException;
import com.excursao.marcinho.mapper.HotelMapper;
import com.excursao.marcinho.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelResponse save (HotelRequest hotelRequest){
        boolean existsByHotel = repository.existsByHotel(hotelRequest.getHotel());
        if (existsByHotel){
            throw new ConflictException("Já existe um hotel com esse nome cadastrado!");
        }
        Hotel entity = mapper.toEntity(hotelRequest);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    public HotelResponse update (Long id, HotelRequest request){
        Hotel hotel = repository.findById(id)
                .orElseThrow(HotelNotFoundException::new);

        mapper.updateEnityFromRequest(request, hotel);
        Hotel atualizado = repository.save(hotel);

        return mapper.toResponse(atualizado);
    }

    public List<HotelResponse> findAll(){
        return mapper.toListResponse(repository.findAll());
    }

    public HotelResponse findByID(Long id){
        Hotel embarque = repository.findById(id)
                .orElseThrow(EmbarqueNotFoundException::new);

        return mapper.toResponse(embarque);
    }

    public void deleteByID (Long id){
        repository.deleteById(id);
    }
}
