package com.br.helpdesk.controlles;

import com.br.helpdesk.services.relatorios.RelatorioService;
import com.br.helpdesk.services.relatorios.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {
    private final RelatorioService relatorioService;

    @GetMapping("/status")
    public ResponseEntity<List<RelatorioStatusDto>> porStatus(@RequestParam LocalDate chaDtDataCriacao) {
        return ResponseEntity.ok(relatorioService.obterChamadosPorStatus(chaDtDataCriacao));
    }

    @GetMapping("/por-tecnico")
    public ResponseEntity<List<RelatorioChamadosPorTecnicoDto>> porTecnico(@RequestParam LocalDate chaDtDataCriacao) {
        return ResponseEntity.ok(relatorioService.obterChamadosPorTecnico(chaDtDataCriacao));
    }

    @GetMapping("/por-dia")
    public ResponseEntity<RelatorioChamadosPorDataDto> porDia(@RequestParam LocalDate chaDtDataCriacao) {
        return ResponseEntity.ok().body(relatorioService.obterChamadosPorData(chaDtDataCriacao));
    }

    @GetMapping("/por-categoria")
    public ResponseEntity<List<RelatorioChamadosPorCategoriaDto>> porCategoria(@RequestParam LocalDate chaDtDataCriacao) {
        return ResponseEntity.ok().body(relatorioService.relatorioChamadosPorCategoria(chaDtDataCriacao));
    }

    @GetMapping("/semanais")
    public ResponseEntity<List<ChamadoSemanalDTO>> getChamadosSemanais() {
        List<ChamadoSemanalDTO> lista = relatorioService.listarChamadosPorSemana();
        return ResponseEntity.ok(lista);
    }
}
