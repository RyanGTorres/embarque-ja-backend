package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.ClienteRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.entity.Cliente;
import com.excursao.marcinho.exceptions.notfound.ClienteNotFoundException;
import com.excursao.marcinho.mapper.ClienteMapper;
import com.excursao.marcinho.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    public ClienteResponse save(ClienteRequest clienteRequest){
        Cliente cliente = mapper.toEntity(clienteRequest);
        Cliente salvo = clienteRepository.save(cliente);
        return mapper.toResponse(salvo);
    }

    public ClienteResponse findById(Long id){
     Cliente cliente = clienteRepository.findById(id)
             .orElseThrow(ClienteNotFoundException::new);
     return mapper.toResponse(cliente);
    }

    public ClienteResponse update(Long id, ClienteRequest clienteRequest){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(ClienteNotFoundException::new);
        mapper.updateResponseFromRequest(clienteRequest, cliente);

        Cliente atualizado = clienteRepository.save(cliente);
        return mapper.toResponse(atualizado);
    }

    public List<ClienteResponse> findAll(){
        return mapper.toListResponse(clienteRepository.findAll());
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
