package com.br.helpdesk.services.relatorios;

import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorDataDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorTecnicoDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioStatusDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioTempoMedioResolucaoDto;

import java.util.List;

public interface RelatorioService {
    List<RelatorioStatusDto> obterChamadosPorStatus();

    List<RelatorioChamadosPorTecnicoDto> obterChamadosPorTecnico();

    List<RelatorioTempoMedioResolucaoDto> obterTempoMedioResolucao();

    List<RelatorioChamadosPorDataDto> obterChamadosPorData();
}
