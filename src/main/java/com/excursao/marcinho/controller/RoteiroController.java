package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.RoteiroRequest;
import com.excursao.marcinho.dto.response.RoteiroResponse;

import com.excursao.marcinho.service.RoteiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roteiro")
@RequiredArgsConstructor
public class RoteiroController {
    private final RoteiroService service;

    @PostMapping
    public ResponseEntity<RoteiroResponse> save (@RequestBody RoteiroRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoteiroResponse> findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoteiroResponse>> findALL(){
            return ResponseEntity.ok(service.findALL());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoteiroResponse> update (@PathVariable Long id, @RequestBody RoteiroRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }
}
