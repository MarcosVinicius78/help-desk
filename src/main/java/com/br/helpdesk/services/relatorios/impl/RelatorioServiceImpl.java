package com.br.helpdesk.services.relatorios.impl;

import com.br.helpdesk.repository.RelatorioRepository;
import com.br.helpdesk.services.relatorios.RelatorioService;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorDataDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorTecnicoDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioStatusDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioTempoMedioResolucaoDto;
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
}
