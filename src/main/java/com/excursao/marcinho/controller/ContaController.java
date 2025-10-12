package com.excursao.marcinho.controller;

import com.excursao.marcinho.entity.Conta;
import com.excursao.marcinho.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> criar(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam(required = false) String biografia,
            @RequestParam(required = false) MultipartFile urlImagem,
            @RequestParam(required = false) MultipartFile logoSideBar) {
        try {
            Conta conta = new Conta();
            conta.setNome(nome);
            conta.setEmail(email);
            conta.setTelefone(telefone);
            conta.setBiografia(biografia);

            Conta novaConta = contaService.criar(conta, urlImagem, logoSideBar);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Conta>> buscarTodas() {
        try {
            List<Conta> contas = contaService.buscarTodas();
            return ResponseEntity.status(HttpStatus.OK).body(contas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        try {
            Optional<Conta> conta = contaService.buscarPorId(id);
            return conta.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizar(
            @PathVariable Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String telefone,
            @RequestParam(required = false) String biografia,
            @RequestParam(required = false) MultipartFile urlImagem,
            @RequestParam(required = false) MultipartFile logoSideBar) {
        try {
            Conta contaAtualizada = new Conta();
            contaAtualizada.setNome(nome);
            contaAtualizada.setEmail(email);
            contaAtualizada.setTelefone(telefone);
            contaAtualizada.setBiografia(biografia);

            Conta conta = contaService.atualizar(id, contaAtualizada, urlImagem, logoSideBar);
            return ResponseEntity.status(HttpStatus.OK).body(conta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            contaService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
