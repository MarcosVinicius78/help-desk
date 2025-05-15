package com.br.helpdesk.controlles;

import com.br.helpdesk.services.relatorios.RelatorioService;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorDataDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorTecnicoDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioStatusDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioTempoMedioResolucaoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {
    private final RelatorioService relatorioService;

    @GetMapping("/status")
    public ResponseEntity<List<RelatorioStatusDto>> porStatus() {
        return ResponseEntity.ok(relatorioService.obterChamadosPorStatus());
    }

    @GetMapping("/por-tecnico")
    public ResponseEntity<List<RelatorioChamadosPorTecnicoDto>> porTecnico() {
        return ResponseEntity.ok(relatorioService.obterChamadosPorTecnico());
    }

    @GetMapping("/tempo-medio")
    public ResponseEntity<List<RelatorioTempoMedioResolucaoDto>> tempoMedio() {
        return ResponseEntity.ok(relatorioService.obterTempoMedioResolucao());
    }

    @GetMapping("/por-dia")
    public ResponseEntity<List<RelatorioChamadosPorDataDto>> porDia() {
        return ResponseEntity.ok(relatorioService.obterChamadosPorData());
    }
}
