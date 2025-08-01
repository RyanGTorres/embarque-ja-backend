package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.EmbarqueRequest;
import com.excursao.marcinho.dto.response.EmbarqueResponse;
import com.excursao.marcinho.entity.Embarque;
import com.excursao.marcinho.mapper.EmbarqueMapper;
import com.excursao.marcinho.repository.EmbarqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmbarqueService {
    private final EmbarqueRepository repository;
    private final EmbarqueMapper mapper;

    public EmbarqueResponse save (EmbarqueRequest request){
        Embarque embarque = mapper.toEntity(request);
        Embarque salvo = repository.save(embarque);
        return mapper.toResponse(salvo);
    }

    public EmbarqueResponse update (Long id, EmbarqueRequest request){
        Embarque embarque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id do Embarque não foi encontrado!"));

        mapper.updateEnittyFromRequest(request, embarque);
        Embarque atualizado = repository.save(embarque);

        return mapper.toResponse(atualizado);
    }

    public List<EmbarqueResponse> findAll(){
        return mapper.toListResponse(repository.findAll());
    }

    public EmbarqueResponse findByID(Long id){
        Embarque embarque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id do Embarque não foi encontrado!"));

        return mapper.toResponse(embarque);
    }

    public void deleteByID (Long id){
        repository.deleteById(id);
    }
}
