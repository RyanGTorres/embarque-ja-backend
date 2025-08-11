package com.excursao.marcinho.controller;


import com.excursao.marcinho.dto.request.ClienteRequest;
import com.excursao.marcinho.dto.response.ClienteResponse;
import com.excursao.marcinho.service.ClienteService;
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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Tag(name = "Cliente", description = "Recurso responsavel pelo gerencimaneto de clientes")
public class ClienteController {

    private final ClienteService service;

    @Operation(summary = "Salvar cliente", description = "Metodo responsavel pelo salvamento de cliente")
    @ApiResponse(responseCode = "201", description = "Cliente salvo com sucesso!",content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
    @PostMapping
    public ResponseEntity<ClienteResponse> save (@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteRequest));
    }

    @Operation(summary = "Buscar cliente pelo ID", description = "Metodo responsavel pela busca de cliente pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cliente não foi encontrado!", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findByID(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @Operation(summary = "Buscar todos os clientes", description = "Metodo responsavel pela busca de todos os clientes")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!",content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cliente não foi encontrado!", content = @Content())
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll(){
       return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Atualizar cliente pelo ID", description = "Metodo responsavel pela atualização do cliente pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso!",content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cliente não foi encontrado!", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update (@PathVariable Long id,@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(service.update(id, clienteRequest));
    }

    @Operation(summary = "Deletar cliente", description = "Método para deletar cliente pelo ID")
    @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado para exclusão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
