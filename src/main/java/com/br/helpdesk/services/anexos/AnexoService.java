package com.br.helpdesk.services.anexos;

import com.br.helpdesk.services.anexos.dto.AnexoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnexoService {
    AnexoDto salvarAnexo(Long chamadoId, Long usuarioId, MultipartFile file);
//    List<AnexoDto> listarTodos();
    AnexoDto buscarAnexoPorId(Long id);
    AnexoDto atualizarAnexo(Long id, MultipartFile novoArquivo);
    void deletarAnexo(Long id);
}
