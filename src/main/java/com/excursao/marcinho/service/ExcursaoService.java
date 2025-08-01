package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.entity.Excursao;
import com.excursao.marcinho.entity.Roteiro;
import com.excursao.marcinho.mapper.ExcursaoMapper;
import com.excursao.marcinho.repository.ExcursaoRepository;
import com.excursao.marcinho.repository.RoteiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExcursaoService {
    private final ExcursaoRepository excursaoRepository;
    private final RoteiroRepository roteiroRepository;
    private final ExcursaoMapper mapper;

    public ExcursaoResponse save (ExcursaoRequest request){
        Excursao excursao = mapper.toEntity(request);

        if (request.getRoteiroId() != null){
            Roteiro roteiro = roteiroRepository.findById(request.getRoteiroId())
                    .orElseThrow(() -> new RuntimeException("O roteiro não encontrou o id!"));

            if (roteiro.getExcursao() != null){
                throw new RuntimeException("Este roteiro já possui uma excursão!");
            }

            excursao.setRoteiro(roteiro);
        }

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
                .orElseThrow(() -> new RuntimeException("O id de excursoa não e valido! ID: "+id));
        return mapper.toResponse(excursao);
    }

    public ExcursaoResponse update (Long id, ExcursaoRequest request){
        Excursao excursao = excursaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id de excursoa não e valido! ID: "+id));

        mapper.updateEntityFromRequest(request, excursao);
        Excursao atualizado = excursaoRepository.save(excursao);

        return mapper.toResponse(atualizado);
    }

    public void deleteById(Long id){
        excursaoRepository.deleteById(id);
    }
}
