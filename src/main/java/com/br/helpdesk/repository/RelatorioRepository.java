package com.br.helpdesk.repository;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorDataDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioChamadosPorTecnicoDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioStatusDto;
import com.br.helpdesk.services.relatorios.dto.RelatorioTempoMedioResolucaoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelatorioRepository extends CrudRepository<ChamadosEntidade, Long> {
    @Query(value = "SELECT cha_tx_status AS status, COUNT(*) AS total FROM cha_chamados GROUP BY cha_tx_status", nativeQuery = true)
    List<RelatorioStatusDto> relatorioPorStatus();

    @Query(value = "SELECT u.usu_tx_nome AS tecnico, COUNT(*) AS totalChamados FROM cha_chamados c JOIN usu_usuarios u ON c.usu_nr_id_tecnico = u.usu_nr_id GROUP BY u.usu_tx_nome", nativeQuery = true)
    List<RelatorioChamadosPorTecnicoDto> relatorioChamadosPorTecnico();

    @Query(value = "SELECT u.usu_tx_nome AS tecnico, AVG(EXTRACT(EPOCH FROM (cha_dt_data_atualizacao - cha_dt_data_criacao))/3600) AS mediaHoras FROM cha_chamados c JOIN usu_usuarios u ON c.usu_nr_id_tecnico = u.usu_nr_id WHERE c.cha_tx_status = 'Resolvido' GROUP BY u.usu_tx_nome", nativeQuery = true)
    List<RelatorioTempoMedioResolucaoDto> relatorioTempoMedioPorTecnico();

    @Query(value = "SELECT TO_CHAR(DATE_TRUNC('day', cha_dt_data_criacao), 'YYYY-MM-DD') AS dia, COUNT(*) AS total FROM cha_chamados GROUP BY dia ORDER BY dia", nativeQuery = true)
    List<RelatorioChamadosPorDataDto> relatorioChamadosPorData();
}
