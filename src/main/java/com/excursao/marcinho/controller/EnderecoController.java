package com.excursao.marcinho.controller;


import com.excursao.marcinho.dto.request.EnderecoRequest;
import com.excursao.marcinho.dto.response.EnderecoResponse;
import com.excursao.marcinho.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponse> save (@RequestBody EnderecoRequest enderecoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoRequest));
    }

}
