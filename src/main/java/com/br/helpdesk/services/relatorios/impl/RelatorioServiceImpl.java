package com.br.helpdesk.services.relatorios.impl;

import com.br.helpdesk.repository.RelatorioRepository;
import com.br.helpdesk.services.relatorios.RelatorioService;
import com.br.helpdesk.services.relatorios.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioServiceImpl implements RelatorioService {
    private final RelatorioRepository relatorioRepository;

    @Override
    public List<RelatorioStatusDto> obterChamadosPorStatus() {
        return relatorioRepository.relatorioPorStatus();
    }

    @Override
    public List<RelatorioChamadosPorTecnicoDto> obterChamadosPorTecnico() {
        return relatorioRepository.relatorioChamadosPorTecnico();
    }

    @Override
    public List<RelatorioTempoMedioResolucaoDto> obterTempoMedioResolucao() {
        return relatorioRepository.relatorioTempoMedioPorTecnico();
    }

    @Override
    public List<RelatorioChamadosPorDataDto> obterChamadosPorData() {
        return relatorioRepository.relatorioChamadosPorData();
    }

    @Override
    public List<RelatorioChamadosPorCategoriaDto> relatorioChamadosPorCategoria() {
        return relatorioRepository.relatorioChamadosPorCategoria();
    }
}
