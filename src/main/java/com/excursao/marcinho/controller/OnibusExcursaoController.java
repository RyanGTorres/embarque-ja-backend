package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;

import com.excursao.marcinho.service.ExcursaoOnibusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/onibusexcursao")
@RequiredArgsConstructor
public class OnibusExcursaoController {
    private final ExcursaoOnibusService service;

    @GetMapping
    public ResponseEntity<List<ExcursaoOnibusResponse>>  findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExcursaoOnibusResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ExcursaoOnibusResponse> save (@RequestBody ExcursaoOnibusRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExcursaoOnibusResponse> update (@PathVariable Long id,@RequestBody ExcursaoOnibusRequest request ){
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
