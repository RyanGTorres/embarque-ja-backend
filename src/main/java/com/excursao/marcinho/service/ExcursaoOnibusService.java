package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import com.excursao.marcinho.entity.Onibus;
import com.excursao.marcinho.exceptions.notfound.ExcursaoNotFoundException;
import com.excursao.marcinho.exceptions.notfound.ExcursaoOnibusNotFoundException;
import com.excursao.marcinho.exceptions.notfound.OnibusNotFoundException;
import com.excursao.marcinho.mapper.ExcursaoOnibusMapper;
import com.excursao.marcinho.repository.ExcursaoOnibusRepository;
import com.excursao.marcinho.repository.ExcursaoRepository;
import com.excursao.marcinho.repository.OnibusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcursaoOnibusService {
    private final ExcursaoRepository excursaoRepository;
    private final OnibusRepository onibusRepository;
    private final ExcursaoOnibusRepository excursaoOnibusRepository;
    private final ExcursaoOnibusMapper mapper;


    public ExcursaoOnibusResponse save (ExcursaoOnibusRequest request){
        Excursao excursao = excursaoRepository.findById(request.getExcursao())
                .orElseThrow(ExcursaoNotFoundException::new);

        Onibus onibus = onibusRepository.findById(request.getOnibus())
                .orElseThrow(OnibusNotFoundException::new);


        ExcursaoOnibus excursaoOnibus = mapper.toEntity(request);

        excursaoOnibus.setExcursao(excursao);
        excursaoOnibus.setOnibus(onibus);

        ExcursaoOnibus atualizado = excursaoOnibusRepository.save(excursaoOnibus);
        return mapper.toResponse(atualizado);
    }

    public List<ExcursaoOnibusResponse> findAll (){
        return mapper.toListResponse(excursaoOnibusRepository.findAll());
    }

    public ExcursaoOnibusResponse findById(Long id){
        ExcursaoOnibus excursao = excursaoOnibusRepository.findById(id)
                .orElseThrow(ExcursaoOnibusNotFoundException::new);
        return mapper.toResponse(excursao);
    }

    public ExcursaoOnibusResponse update (Long id, ExcursaoOnibusRequest request){
        ExcursaoOnibus excursao = excursaoOnibusRepository.findById(id)
                .orElseThrow(ExcursaoOnibusNotFoundException::new);

        if (request.getExcursao() != null){
            excursaoRepository.findById(request.getExcursao())
                    .orElseThrow(ExcursaoNotFoundException::new);
        }

        if (request.getOnibus() != null){
            onibusRepository.findById(request.getOnibus())
                    .orElseThrow(OnibusNotFoundException::new);
        }

        mapper.updateEnityFromRequest(request, excursao);
        ExcursaoOnibus atualzizado = excursaoOnibusRepository.save(excursao);

        return mapper.toResponse(atualzizado);
    }

    public void deleteById(Long id){
        excursaoOnibusRepository.deleteById(id);
    }
}
