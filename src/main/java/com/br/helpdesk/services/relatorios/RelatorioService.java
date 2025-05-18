package com.br.helpdesk.services.relatorios;

import com.br.helpdesk.services.relatorios.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioService {
    List<RelatorioStatusDto> obterChamadosPorStatus(LocalDate chaDtDataCriacao);

    List<RelatorioChamadosPorTecnicoDto> obterChamadosPorTecnico(LocalDate chaDtDataCriacao);

    RelatorioChamadosPorDataDto obterChamadosPorData(LocalDate chaDtDataCriacao);

    List<RelatorioChamadosPorCategoriaDto> relatorioChamadosPorCategoria(LocalDate chaDtDataCriacao);

    List<ChamadoSemanalDTO> listarChamadosPorSemana();
}
