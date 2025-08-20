package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.entity.Embarque;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Hotel;
import com.excursao.marcinho.enums.StatusViagem;
import com.excursao.marcinho.exceptions.notfound.EmbarqueNotFoundException;
import com.excursao.marcinho.exceptions.notfound.ExcursaoNotFoundException;
import com.excursao.marcinho.exceptions.notfound.HotelNotFoundException;
import com.excursao.marcinho.mapper.ExcursaoMapper;
import com.excursao.marcinho.repository.EmbarqueRepository;
import com.excursao.marcinho.repository.ExcursaoRepository;
import com.excursao.marcinho.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExcursaoService {
    private final ExcursaoRepository excursaoRepository;
    private final EmbarqueRepository embarqueRepository;
    private final HotelRepository hotelRepository;
    private final ExcursaoMapper mapper;

    public ExcursaoResponse save (ExcursaoRequest request){
        Excursao excursao = mapper.toEntity(request);

        if (request.getEmbarquesIds() != null && !request.getEmbarquesIds().isEmpty()){
            List<Embarque> embarques = embarqueRepository.findAllById(request.getEmbarquesIds());

            if (embarques.size() != request.getEmbarquesIds().size()){
                throw new EmbarqueNotFoundException();
            }

            excursao.setEmbarques(embarques);
        }

        if (request.getHoteisIds() != null && !request.getHoteisIds().isEmpty()){
            List<Hotel> hotelList = hotelRepository.findAllById(request.getHoteisIds());
            if (hotelList.size()!= request.getHoteisIds().size()){
                throw new HotelNotFoundException();
            }

            excursao.setHoteis(hotelList);
        }

        excursao.setStatusViagem(StatusViagem.DISPONIVEL);
        Excursao atualizado = excursaoRepository.save(excursao);
        return mapper.toResponse(atualizado);

    }

    public List<ExcursaoResponse> findAll(){
        List<Excursao> excursaoList = excursaoRepository.findAll();
        return excursaoList.stream()
                .map(mapper::toResponse).toList();
    }

    public ExcursaoResponse findById(Long id){
        Excursao excursao = excursaoRepository.findById(id)
                .orElseThrow(ExcursaoNotFoundException::new);

        if (LocalDate.now().isAfter(excursao.getDataSaida())){
            excursao.setStatusViagem(StatusViagem.FINALIZADA);
            excursaoRepository.save(excursao);
        }

        return mapper.toResponse(excursao);
    }

    public ExcursaoResponse update (Long id, ExcursaoRequest request){
        Excursao excursao = excursaoRepository.findById(id)
                .orElseThrow(ExcursaoNotFoundException::new);

        mapper.updateEntityFromRequest(request, excursao);

        if (request.getEmbarquesIds() != null){
            if (request.getEmbarquesIds().isEmpty()){
                excursao.setEmbarques(new ArrayList<>());
            }
            List<Embarque> embarqueList = embarqueRepository.findAllById(request.getEmbarquesIds());

            if (embarqueList.size() != request.getEmbarquesIds().size()){
                throw new EmbarqueNotFoundException();
            }
            excursao.setEmbarques(embarqueList);
        }


        Excursao atualizado = excursaoRepository.save(excursao);

        return mapper.toResponse(atualizado);
    }

    public void deleteById(Long id){
        excursaoRepository.deleteById(id);
    }

}
