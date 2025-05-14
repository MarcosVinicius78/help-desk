package com.br.helpdesk.controlles;

import com.br.helpdesk.services.anexos.AnexoService;
import com.br.helpdesk.services.anexos.dto.AnexoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/anexos")
@RequiredArgsConstructor
public class AnexoController {
    private final AnexoService anexoService;

    @PostMapping("/upload")
    public ResponseEntity<AnexoDto> uploadAnexo(
            @RequestParam("chamadoId") Long chamadoId,
            @RequestParam("usuarioId") Long usuarioId,
            @RequestParam("file") MultipartFile file
    ) {
        AnexoDto anexo = anexoService.salvarAnexo(chamadoId, usuarioId, file);
        return ResponseEntity.ok(anexo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDto> buscarAnexoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(anexoService.buscarAnexoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnexoDto> atualizarAnexo(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile novoArquivo
    ) {
        return ResponseEntity.ok(anexoService.atualizarAnexo(id, novoArquivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnexo(@PathVariable Long id) {
        anexoService.deletarAnexo(id);
        return ResponseEntity.noContent().build();
    }
}
