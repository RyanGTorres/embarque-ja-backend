package com.excursao.marcinho.service;

import com.excursao.marcinho.entity.Conta;
import com.excursao.marcinho.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    private static final String UPLOAD_DIR = "uploads/contas/";

    public Conta criar(Conta conta, MultipartFile urlImagem, MultipartFile logoSideBar) {
        try {
            if (urlImagem != null && !urlImagem.isEmpty()) {
                conta.setUrlImagem(salvarImagem(urlImagem));
            }
            if (logoSideBar != null && !logoSideBar.isEmpty()) {
                conta.setLogoSideBar(salvarImagem(logoSideBar));
            }
            return contaRepository.save(conta);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload de imagens: " + e.getMessage());
        }
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    public List<Conta> buscarTodas() {
        return contaRepository.findAll();
    }

    public Conta atualizar(Long id, Conta contaAtualizada, MultipartFile urlImagem, MultipartFile logoSideBar) {
        try {
            Optional<Conta> contaExistente = contaRepository.findById(id);
            if (contaExistente.isPresent()) {
                Conta conta = contaExistente.get();

                if (contaAtualizada.getNome() != null) {
                    conta.setNome(contaAtualizada.getNome());
                }
                if (contaAtualizada.getEmail() != null) {
                    conta.setEmail(contaAtualizada.getEmail());
                }
                if (contaAtualizada.getTelefone() != null) {
                    conta.setTelefone(contaAtualizada.getTelefone());
                }
                if (contaAtualizada.getBiografia() != null) {
                    conta.setBiografia(contaAtualizada.getBiografia());
                }

                if (urlImagem != null && !urlImagem.isEmpty()) {
                    conta.setUrlImagem(salvarImagem(urlImagem));
                }

                if (logoSideBar != null && !logoSideBar.isEmpty()) {
                    conta.setLogoSideBar(salvarImagem(logoSideBar));
                }

                return contaRepository.save(conta);
            }
            throw new RuntimeException("Conta não encontrada com ID: " + id);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload de imagens: " + e.getMessage());
        }
    }

    public void deletar(Long id) {
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conta não encontrada com ID: " + id);
        }
    }

    private String salvarImagem(MultipartFile arquivo) throws IOException {
        if (arquivo.isEmpty()) {
            throw new RuntimeException("Arquivo vazio");
        }

        // Validar tipo de arquivo
        String contentType = arquivo.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new RuntimeException("Arquivo deve ser uma imagem");
        }

        // Criar diretório se não existir
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Gerar nome único para o arquivo
        String nomeArquivo = UUID.randomUUID() + "_" + arquivo.getOriginalFilename();
        Path caminhoCompleto = uploadPath.resolve(nomeArquivo);

        // Salvar arquivo
        Files.write(caminhoCompleto, arquivo.getBytes());

        return UPLOAD_DIR + nomeArquivo;
    }
}
