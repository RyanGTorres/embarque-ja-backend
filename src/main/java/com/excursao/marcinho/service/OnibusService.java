package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.OnibusRequest;
import com.excursao.marcinho.dto.response.OnibusResponse;
import com.excursao.marcinho.entity.Onibus;
import com.excursao.marcinho.exceptions.conflict.ConflictException;
import com.excursao.marcinho.exceptions.notfound.OnibusNotFoundException;
import com.excursao.marcinho.mapper.OnibusMapper;
import com.excursao.marcinho.repository.OnibusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OnibusService {
    private final OnibusRepository repository;
    private final OnibusMapper mapper;

    public OnibusResponse save (OnibusRequest request){
        boolean existsOnibus = repository.existsByModeloAndEmpresa(request.getModelo(), request.getEmpresa());

        if (existsOnibus){
            throw new ConflictException("Já existe um onibus com essas informações!");
        }

        Onibus onibus = mapper.toEntity(request);
        Onibus salvo = repository.save(onibus);
        return mapper.toResponse(salvo);
    }

    public List<OnibusResponse>  findAll(){
        return mapper.toListResponse(repository.findAll());
    }

    public OnibusResponse findByID(Long id){
        Onibus onibus = repository.findById(id)
                .orElseThrow(OnibusNotFoundException::new);
        return mapper.toResponse(onibus);
    }

    public OnibusResponse update (Long id, OnibusRequest onibusRequest){
        Onibus onibus = repository.findById(id)
                .orElseThrow(OnibusNotFoundException::new);

        mapper.updateFromResponse(onibusRequest, onibus);
        Onibus atualizado = repository.save(onibus);

        return mapper.toResponse(atualizado);
    }

    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new OnibusNotFoundException();
        }

        repository.deleteById(id);
    }
}
