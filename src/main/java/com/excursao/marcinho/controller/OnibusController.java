package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.OnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.dto.response.OnibusResponse;
import com.excursao.marcinho.service.OnibusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/onibus")
@RequiredArgsConstructor
@Tag(name = "Onibus", description = "Recurso responsavel pelo gerencimaneto de Onibus")
public class OnibusController {
    private final OnibusService service;

    @Operation(summary = "Salvar onibus", description = "Metodo responsavel pelo salvamento de onibus")
    @ApiResponse(responseCode = "201", description = "Onibus salvo com sucesso!",content = @Content(schema = @Schema(implementation = OnibusResponse.class)))
    @PostMapping
    public ResponseEntity<OnibusResponse> save (@Valid @RequestBody OnibusRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request)) ;
    }

    @Operation(summary = "Buscar onibus pelo ID", description = "Metodo responsavel pela busca de onibus pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Onibus encontrado com sucesso!",content = @Content(schema = @Schema(implementation = OnibusResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<OnibusResponse>  findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findByID(id));
    }


    @Operation(summary = "Buscar todos os onibus", description = "Metodo responsavel pela busca de todos os onibus")
    @ApiResponse(responseCode = "200", description = "Onibus encontrado com sucesso!",content = @Content(schema = @Schema(implementation = OnibusResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<OnibusResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Atualizar onibus pelo ID", description = "Metodo responsavel pela atualização do onibus pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Onibus atualizado com sucesso!",content = @Content(schema = @Schema(implementation = OnibusResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<OnibusResponse>  update(@PathVariable Long id,@Valid @RequestBody OnibusRequest request){
        return ResponseEntity.ok( service.update(id, request));
    }

    @Operation(summary = "Deletar onibus", description = "Método para deletar onibus pelo ID")
    @ApiResponse(responseCode = "204", description = "Onibus deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Onibus não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
