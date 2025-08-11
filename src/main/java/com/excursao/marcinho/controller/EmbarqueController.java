package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.EmbarqueRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.dto.response.EmbarqueResponse;
import com.excursao.marcinho.service.EmbarqueService;
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
@RequestMapping("/api/embarque")
@RequiredArgsConstructor
@Tag(name = "Embarque", description = "Recurso responsavel pelo gerencimaneto de embarque")
public class EmbarqueController {
    private final EmbarqueService service;

    @Operation(summary = "Salvar embarque", description = "Metodo responsavel pelo salvamento de embarque")
    @ApiResponse(responseCode = "201", description = "Embarque salvo com sucesso!",content = @Content(schema = @Schema(implementation = EmbarqueResponse.class)))
    @PostMapping
    public ResponseEntity<EmbarqueResponse> save (@Valid @RequestBody EmbarqueRequest embarqueRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(embarqueRequest));
    }

    @Operation(summary = "Buscar embarque pelo ID", description = "Metodo responsavel pela busca de embarque pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Embarque encontrado com sucesso!",content = @Content(schema = @Schema(implementation = EmbarqueResponse.class)))
    @ApiResponse(responseCode = "404", description = "Embarque não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmbarqueResponse findById(@PathVariable Long id){
        return service.findByID(id);
    }

    @Operation(summary = "Buscar todos os embarques", description = "Metodo responsavel pela busca de todos os embarques")
    @ApiResponse(responseCode = "200", description = "Embarques encontrado com sucesso!",content = @Content(schema = @Schema(implementation = EmbarqueResponse.class)))
    @ApiResponse(responseCode = "404", description = "Embarques não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<EmbarqueResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Atualizar embarque pelo ID", description = "Metodo responsavel pela atualização do embarque pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Embarque atualizado com sucesso!",content = @Content(schema = @Schema(implementation = EmbarqueResponse.class)))
    @ApiResponse(responseCode = "404", description = "Embarque não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<EmbarqueResponse> update (@PathVariable Long id, @Valid @RequestBody EmbarqueRequest embarqueRequest){
        return ResponseEntity.ok(service.update(id, embarqueRequest));
    }

    @Operation(summary = "Deletar embarque", description = "Método para deletar embarque pelo ID")
    @ApiResponse(responseCode = "204", description = "Embarque deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Embarque não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

}
