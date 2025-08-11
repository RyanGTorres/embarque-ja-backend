package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.ExcursaoRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.dto.response.EmbarqueResponse;
import com.excursao.marcinho.dto.response.ExcursaoResponse;
import com.excursao.marcinho.service.ExcursaoService;
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
@RequestMapping("/api/excursao")
@RequiredArgsConstructor
@Tag(name = "Excursao", description = "Recurso responsavel pelo gerencimaneto de excursao")
public class ExcursaoController {
    private final ExcursaoService excursaoService;

    @Operation(summary = "Salvar excursao", description = "Metodo responsavel pelo salvamento de excursao")
    @ApiResponse(responseCode = "201", description = "Embarque salvo com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoResponse.class)))
    @PostMapping
    public ResponseEntity<ExcursaoResponse> save(@Valid @RequestBody ExcursaoRequest excursaoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(excursaoService.save(excursaoRequest));
    }

    @Operation(summary = "Buscar excursao pelo ID", description = "Metodo responsavel pela busca de excursao pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Embarque encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Embarque não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<ExcursaoResponse> findByID(@PathVariable Long id){
        return ResponseEntity.ok(excursaoService.findById(id));
    }

    @Operation(summary = "Buscar todos os excursões", description = "Metodo responsavel pela busca de todos os excursões")
    @ApiResponse(responseCode = "200", description = "Excursão encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Excursão não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<ExcursaoResponse>> findAll(){
        return ResponseEntity.ok(excursaoService.findAll());
    }

    @Operation(summary = "Atualizar excursao pelo ID", description = "Metodo responsavel pela atualização do excursao pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Excursão atualizado com sucesso!",content = @Content(schema = @Schema(implementation = ExcursaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Excursão não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<ExcursaoResponse> update(@PathVariable Long id, @Valid @RequestBody ExcursaoRequest excursaoRequest){
        return ResponseEntity.ok(excursaoService.update(id, excursaoRequest));
    }

    @Operation(summary = "Deletar excursao", description = "Método para deletar excursão pelo ID")
    @ApiResponse(responseCode = "204", description = "Excursão deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Excursão não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        excursaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
