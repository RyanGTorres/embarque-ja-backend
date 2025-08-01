package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.RoteiroRequest;
import com.excursao.marcinho.dto.response.RoteiroResponse;
import com.excursao.marcinho.entity.Embarque;
import com.excursao.marcinho.entity.Roteiro;
import com.excursao.marcinho.mapper.RoteiroMapper;
import com.excursao.marcinho.repository.EmbarqueRepository;
import com.excursao.marcinho.repository.RoteiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoteiroService {
    private final RoteiroRepository roteiroRepository;
    private final EmbarqueRepository embarqueRepository;
    private final RoteiroMapper roteiroMapper;

    public RoteiroResponse save (RoteiroRequest request){
        Roteiro roteiro = roteiroMapper.toEntity(request);

        if (request.getEmbarquesIds() != null && !request.getEmbarquesIds().isEmpty()){
            List<Embarque> embarques = embarqueRepository.findAllById(request.getEmbarquesIds());

            if (embarques.size() != request.getEmbarquesIds().size()){
                throw new RuntimeException("Alguns embarques não foram encontrados!");
            }

            roteiro.setEmbarques(embarques);
        }else {
            roteiro.setEmbarques(new ArrayList<>());
        }
        Roteiro salvo = roteiroRepository.save(roteiro);
        return roteiroMapper.toResponse(salvo);
    }

    public RoteiroResponse atualizar(Long id, RoteiroRequest request){
        Roteiro roteiro = roteiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id do roteiro não foi encontrado!"));

        roteiroMapper.updateEntityFromRequest(request, roteiro);

        if (request.getEmbarquesIds() != null){
            if (request.getEmbarquesIds().isEmpty()){
                roteiro.setEmbarques(new ArrayList<>());
            }
            List<Embarque> embarquesNovos = embarqueRepository.findAllById(request.getEmbarquesIds());
            roteiro.setEmbarques(embarquesNovos);
        }

        Roteiro atualizado = roteiroRepository.save(roteiro);
        return roteiroMapper.toResponse(atualizado);
    }

    public List<RoteiroResponse> findALL(){
        List<Roteiro> roteiro = roteiroRepository.findAll();

        return roteiro.stream()
                .map(roteiroMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RoteiroResponse findById(Long id){
        Roteiro roteiro = roteiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id do roteiro não foi encontrado!"));
        return roteiroMapper.toResponse(roteiro);
    }

    public void delete (Long id){
        roteiroRepository.deleteById(id);
    }
}
