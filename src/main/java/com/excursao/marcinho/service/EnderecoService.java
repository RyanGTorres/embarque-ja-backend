package com.excursao.marcinho.service;

import com.excursao.marcinho.dto.request.EnderecoRequest;
import com.excursao.marcinho.dto.response.EnderecoResponse;
import com.excursao.marcinho.entity.Cliente;
import com.excursao.marcinho.entity.Endereco;
import com.excursao.marcinho.mapper.EnderecoMapper;
import com.excursao.marcinho.repository.ClienteRepository;
import com.excursao.marcinho.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoMapper enderecoMapper;

    public EnderecoResponse save(EnderecoRequest enderecoRequest){
        Cliente cliente = clienteRepository.findById(enderecoRequest.clienteID()).orElseThrow(() -> new RuntimeException("O id de cliente não é valido!"));
        Endereco endereco = enderecoMapper.toEntity(enderecoRequest,cliente);
        Endereco salvar = enderecoRepository.save(endereco);
        return enderecoMapper.toResponse(salvar);
    }


}

