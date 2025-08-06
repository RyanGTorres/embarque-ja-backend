package com.excursao.marcinho.controller;


import com.excursao.marcinho.dto.request.ClienteRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponse> save (@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll(){
       return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update (@PathVariable Long id,@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(service.update(id, clienteRequest));
    }
}
