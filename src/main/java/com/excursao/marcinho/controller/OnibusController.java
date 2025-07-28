package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.OnibusRequest;
import com.excursao.marcinho.dto.response.OnibusResponse;
import com.excursao.marcinho.service.OnibusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/onibus")
@RequiredArgsConstructor
public class OnibusController {
    private final OnibusService service;

    @PostMapping
    public ResponseEntity<OnibusResponse> save (@RequestBody OnibusRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnibusResponse>  update(@PathVariable Long id, @RequestBody OnibusRequest request){
        return ResponseEntity.ok( service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnibusResponse>  findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<OnibusResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
