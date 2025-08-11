package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoOnibusRequest;
import com.excursao.marcinho.dto.response.ExcursaoOnibusResponse;

import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.service.ExcursaoOnibusService;
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
@RequestMapping("/api/onibusexcursao")
@RequiredArgsConstructor
@Tag(name = "Onibus com Excursao", description = "Recurso responsavel pelo gerencimaneto de Onibus com Excursao")
public class OnibusExcursaoController {
    private final ExcursaoOnibusService service;

    @Operation(summary = "Salvar Onibus com Excursao", description = "Metodo responsavel pelo salvamento de Onibus com Excursao")
    @ApiResponse(responseCode = "201", description = "Onibus com Excursao salvo com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoOnibusResponse.class)))
    @PostMapping
    public ResponseEntity<ExcursaoOnibusResponse> save (@Valid @RequestBody ExcursaoOnibusRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @Operation(summary = "Buscar Onibus com Excursao pelo ID", description = "Metodo responsavel pela busca de Onibus com Excursao pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Onibus com Excursao encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoOnibusResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus com Excursao não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<ExcursaoOnibusResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @Operation(summary = "Buscar todos os Onibus com Excursao", description = "Metodo responsavel pela busca de todos os Onibus com Excursao")
    @ApiResponse(responseCode = "200", description = "Onibus com Excursao encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus com Excursao não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<ExcursaoOnibusResponse>>  findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Atualizar Onibus com Excursao pelo ID", description = "Metodo responsavel pela atualização do Onibus com Excursao pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Onibus com Excursao atualizado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoOnibusResponse.class)))
    @ApiResponse(responseCode = "404", description = "Onibus com Excursao não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<ExcursaoOnibusResponse> update (@PathVariable Long id,@Valid @RequestBody ExcursaoOnibusRequest request ){
        return ResponseEntity.ok(service.update(id, request));
    }

    @Operation(summary = "Deletar Onibus com Excursao", description = "Método para deletar Onibus com Excursao pelo ID")
    @ApiResponse(responseCode = "204", description = "Onibus com Excursao deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Onibus com Excursao não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
