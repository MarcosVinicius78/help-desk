package com.br.helpdesk.services.relatorios;

import com.br.helpdesk.services.relatorios.dto.*;

import java.util.List;

public interface RelatorioService {
    List<RelatorioStatusDto> obterChamadosPorStatus();

    List<RelatorioChamadosPorTecnicoDto> obterChamadosPorTecnico();

    List<RelatorioTempoMedioResolucaoDto> obterTempoMedioResolucao();

    List<RelatorioChamadosPorDataDto> obterChamadosPorData();

    List<RelatorioChamadosPorCategoriaDto> relatorioChamadosPorCategoria();
}
