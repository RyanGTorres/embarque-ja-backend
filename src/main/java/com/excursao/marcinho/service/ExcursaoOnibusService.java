package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.ExcursaoOnibus;
import com.excursao.marcinho.entity.Onibus;
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
                .orElseThrow(() -> new RuntimeException("O id de excusão é invalido! ID:"+request.getOnibus()) );

        Onibus onibus = onibusRepository.findById(request.getOnibus())
                .orElseThrow(() -> new RuntimeException("O id de excusão é invalido! ID:"+request.getOnibus()) );


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
                .orElseThrow(() -> new RuntimeException("O id digitado não é valido! ID: "+id));
        return mapper.toResponse(excursao);
    }

    public ExcursaoOnibusResponse update (Long id, ExcursaoOnibusRequest request){
        ExcursaoOnibus excursao = excursaoOnibusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id digitado não é valido! ID: "+id));

        if (request.getExcursao() != null){
            excursaoRepository.findById(request.getExcursao())
                    .orElseThrow(() -> new RuntimeException("O id excursao não é valido! ID: "+ request.getExcursao()));
        }

        if (request.getOnibus() != null){
            onibusRepository.findById(request.getOnibus())
                    .orElseThrow(() -> new RuntimeException("O id onibus não é valido! ID: "+ request.getOnibus()));
        }

        mapper.updateEnityFromRequest(request, excursao);
        ExcursaoOnibus atualzizado = excursaoOnibusRepository.save(excursao);

        return mapper.toResponse(atualzizado);
    }

    public void deleteById(Long id){
        excursaoOnibusRepository.deleteById(id);
    }
}
