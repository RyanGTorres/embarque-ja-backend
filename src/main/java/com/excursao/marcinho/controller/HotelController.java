package com.excursao.marcinho.controller;

import com.excursao.marcinho.dto.request.HotelRequest;
import com.excursao.marcinho.dto.response.HotelResponse;
import com.excursao.marcinho.service.HotelService;
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
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
@Tag(name = "Hotel", description = "Recurso responsavel pelo gerencimaneto de hotel")
public class HotelController {
    private final HotelService service;

    @Operation(summary = "Salvar hotel", description = "Metodo responsavel pelo salvamento de hotel")
    @ApiResponse(responseCode = "201", description = "Hotel salvo com sucesso!",content = @Content(schema = @Schema(implementation = HotelResponse.class)))
    @PostMapping
    public ResponseEntity<HotelResponse> save (@Valid @RequestBody HotelRequest hotelRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(hotelRequest));
    }

    @Operation(summary = "Buscar Hotel pelo ID", description = "Metodo responsavel pela busca de hotel pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Hotel encontrado com sucesso!",content = @Content(schema = @Schema(implementation = HotelResponse.class)))
    @ApiResponse(responseCode = "404", description = "Hotel não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse findById(@PathVariable Long id){
        return service.findByID(id);
    }

    @Operation(summary = "Buscar todos os hotel", description = "Metodo responsavel pela busca de todos os hotel")
    @ApiResponse(responseCode = "200", description = "Hotel encontrado com sucesso!",content = @Content(schema = @Schema(implementation = HotelResponse.class)))
    @ApiResponse(responseCode = "404", description = "Hotel não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<HotelResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Atualizar hotel pelo ID", description = "Metodo responsavel pela atualização do hotel pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Hotel atualizado com sucesso!",content = @Content(schema = @Schema(implementation = HotelResponse.class)))
    @ApiResponse(responseCode = "404", description = "Hotel não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> update (@PathVariable Long id, @Valid @RequestBody HotelRequest hotelRequest){
        return ResponseEntity.ok(service.update(id, hotelRequest));
    }

    @Operation(summary = "Deletar hotel", description = "Método para deletar hotel pelo ID")
    @ApiResponse(responseCode = "204", description = "Hotel deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Hotel não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
