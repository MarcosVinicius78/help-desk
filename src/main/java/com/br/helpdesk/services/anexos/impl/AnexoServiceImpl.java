package com.br.helpdesk.services.anexos.impl;

import com.br.helpdesk.models.AnexosEntidade;
import com.br.helpdesk.repository.AnexoRepository;
import com.br.helpdesk.services.anexos.AnexoService;
import com.br.helpdesk.services.anexos.dto.AnexoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnexoServiceImpl implements AnexoService {

    private final AnexoRepository anexoRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public AnexoDto salvarAnexo(Long chamadoId, Long usuarioId, MultipartFile file) {
        String nomeArquivo = salvarArquivoNoDisco(file);
        AnexosEntidade anexo = new AnexosEntidade();
        anexo.setChaNrId(chamadoId);
        anexo.setUsuNrId(usuarioId);
        anexo.setAneTxAnexoUrl("/" + uploadDir + "/" + nomeArquivo);
        anexo.setAneDtDataUpload(LocalDateTime.now());
        return new AnexoDto(anexoRepository.save(anexo));
    }

//    @Override
//    public List<AnexoDto> listarTodos() {
//        return anexoRepository.findAll().stream().map(AnexoDto::new).toList();
//    }

    @Override
    public AnexoDto buscarAnexoPorId(Long id) {
        return anexoRepository.findById(id).map(AnexoDto::new)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
    }

    @Override
    public AnexoDto atualizarAnexo(Long id, MultipartFile novoArquivo) {
        AnexosEntidade anexo = anexoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));

        deletarArquivo(anexo.getAneTxAnexoUrl()); // remove o antigo

        String nomeArquivoNovo = salvarArquivoNoDisco(novoArquivo);
        anexo.setAneTxAnexoUrl("/" + uploadDir + "/" + nomeArquivoNovo);
        anexo.setAneDtDataUpload(LocalDateTime.now());

        return new AnexoDto(anexoRepository.save(anexo));
    }

    @Override
    public void deletarAnexo(Long id) {
        Optional<AnexosEntidade> anexoOpt = anexoRepository.findById(id);
        anexoOpt.ifPresent(anexo -> {
            deletarArquivo(anexo.getAneTxAnexoUrl());
            anexoRepository.delete(anexo);
        });
    }

    private String salvarArquivoNoDisco(MultipartFile file) {
        try {
            File pasta = new File(uploadDir).getAbsoluteFile();
            if (!pasta.exists()) pasta.mkdirs();

            String nomeArquivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
            String caminhoCompleto = uploadDir + File.separator + nomeArquivo;
            file.transferTo(new File(caminhoCompleto));

            return nomeArquivo;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo", e);
        }
    }

    private void deletarArquivo(String caminhoRelativo) {
        if (caminhoRelativo == null) return;
        File arquivo = new File("." + caminhoRelativo); // "." porque começa com "/uploads/"
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }
}
