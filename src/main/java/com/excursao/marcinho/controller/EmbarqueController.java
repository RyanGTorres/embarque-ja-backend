package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.EmbarqueRequest;
import com.excursao.marcinho.dto.response.EmbarqueResponse;
import com.excursao.marcinho.service.EmbarqueService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/embarque")
@RequiredArgsConstructor
public class EmbarqueController {
    private final EmbarqueService service;

    @GetMapping("/{id}")
    public ResponseEntity<EmbarqueResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<EmbarqueResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<EmbarqueResponse> save (@RequestBody EmbarqueRequest embarqueRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(embarqueRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmbarqueResponse> update (@PathVariable Long id, @RequestBody EmbarqueRequest embarqueRequest){
        return ResponseEntity.ok(service.update(id, embarqueRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

}
