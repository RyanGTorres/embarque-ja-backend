package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.service.ExcursaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excursao")
@RequiredArgsConstructor
public class ExcursaoController {
    private final ExcursaoService excursaoService;

    @GetMapping("/{id}")
    public ResponseEntity<ExcursaoResponse> findByID(@PathVariable Long id){
        return ResponseEntity.ok(excursaoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExcursaoResponse>> findAll(){
        return ResponseEntity.ok(excursaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ExcursaoResponse> save(@RequestBody ExcursaoRequest excursaoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(excursaoService.save(excursaoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExcursaoResponse> update(@PathVariable Long id, @RequestBody ExcursaoRequest excursaoRequest){
        return ResponseEntity.ok(excursaoService.update(id, excursaoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        excursaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
