package com.br.helpdesk.services.relatorios.impl;

import com.br.helpdesk.repository.RelatorioRepository;
import com.br.helpdesk.services.relatorios.RelatorioService;
import com.br.helpdesk.services.relatorios.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioServiceImpl implements RelatorioService {
    private final RelatorioRepository relatorioRepository;

    @Override
    public List<RelatorioStatusDto> obterChamadosPorStatus(LocalDate chaDtDataCriacao) {
        return relatorioRepository.relatorioPorStatus(chaDtDataCriacao);
    }

    @Override
    public List<RelatorioChamadosPorTecnicoDto> obterChamadosPorTecnico(LocalDate chaDtDataCriacao) {
        return relatorioRepository.relatorioChamadosPorTecnico(chaDtDataCriacao);
    }

    @Override
    public RelatorioChamadosPorDataDto obterChamadosPorData(LocalDate chaDtDataCriacao) {
        return relatorioRepository.relatorioChamadosPorData(chaDtDataCriacao);
    }

    @Override
    public List<ChamadoSemanalDTO> listarChamadosPorSemana() {
        return relatorioRepository.obterChamadosPorSemana();
    }

    @Override
    public List<RelatorioChamadosPorCategoriaDto> relatorioChamadosPorCategoria(LocalDate chaDtDataCriacao) {
        return relatorioRepository.relatorioChamadosPorCategoria(chaDtDataCriacao);
    }
}
