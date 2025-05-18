package com.br.helpdesk.controlles;

import com.br.helpdesk.services.chamados.ChamadosServices;
import com.br.helpdesk.services.chamados.dto.ChamadoDadosCompletosDto;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadosController {

    private final ChamadosServices chamadosServices;

//    @GetMapping
//    public ResponseEntity<List<ChamadoDto>> listarChamados() {
//        return ResponseEntity.ok().body(chamadosServices.listarChamados());
//    }

    @GetMapping
    public ResponseEntity<Page<ChamadoDadosCompletosDto>> listarChamados(
            ChamadoForm filtro,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(chamadosServices.listarChamados(filtro, pageable));
    }

    @GetMapping("/cliente/{usuNrIdCliente}")
    public ResponseEntity<Page<ChamadoDadosCompletosDto>> listarPorCliente(
            @PathVariable Long usuNrIdCliente,
            ChamadoForm filtro,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(chamadosServices.listarChamadosPorCliente(usuNrIdCliente, filtro, pageable));
    }

    @GetMapping("/tecnico/{usuNrIdTecnico}")
    public ResponseEntity<Page<ChamadoDadosCompletosDto>> listarPorTecnico(
            @PathVariable Long usuNrIdTecnico,
            ChamadoForm filtro,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(chamadosServices.listarChamadosPorTecnico(usuNrIdTecnico, filtro, pageable));
    }
//
//    @GetMapping("/cliente/{usuNrIdCliente}")
//    public ResponseEntity<List<ChamadoDto>> listarPorCliente(@PathVariable Long usuNrIdCliente) {
//        return ResponseEntity.ok(chamadosServices.listarChamadosPorCliente(usuNrIdCliente));
//    }
//
//    @GetMapping("/tecnico/{usuNrIdTecnico}")
//    public ResponseEntity<List<ChamadoDto>> listarPorTecnico(@PathVariable Long usuNrIdTecnico) {
//        return ResponseEntity.ok(chamadosServices.listarChamadosPorTecnico(usuNrIdTecnico));
//    }
//




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

    @PutMapping("/{chaNrId}/atribuir-chamado/{usuNrIdTecnico}")
    public ResponseEntity<ChamadoDto> atribuirChamadoAUmTecnico(@PathVariable Long chaNrId, @PathVariable Long usuNrIdTecnico) {
        return ResponseEntity.ok().body(chamadosServices.atribuirChamado(chaNrId, usuNrIdTecnico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChamado(@PathVariable Long id) {
        chamadosServices.deletarChamado(id);
        return ResponseEntity.noContent().build();
    }
}
