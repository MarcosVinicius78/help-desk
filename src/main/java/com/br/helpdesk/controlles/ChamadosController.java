package com.br.helpdesk.controlles;

import com.br.helpdesk.services.chamados.ChamadosServices;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadosController {

    private final ChamadosServices chamadosServices;

    @GetMapping
    public ResponseEntity<List<ChamadoDto>> listarChamados() {
        return ResponseEntity.ok().body(chamadosServices.listarChamados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDto> buscarChamadoPorId(@PathVariable Long id) {
       return ResponseEntity.ok().body(chamadosServices.buscarChamadoPorId(id));
    }

    @PostMapping
    public ResponseEntity<ChamadoDto> criarChamado(@RequestBody ChamadoForm form) {
        return ResponseEntity.ok().body(chamadosServices.criarChamado(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDto> atualizarChamado(@PathVariable Long id, @RequestBody ChamadoForm form) {
        return ResponseEntity.ok().body(chamadosServices.atualizarChamado(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChamado(@PathVariable Long id) {
        chamadosServices.deletarChamado(id);
        return ResponseEntity.noContent().build();
    }
}
