package com.br.helpdesk.repository;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.services.relatorios.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioRepository extends CrudRepository<ChamadosEntidade, Long> {
    @Query(value = """
        SELECT
            cha_tx_status AS status,
            COUNT(*) AS total
        FROM
            cha_chamados
        WHERE
            cha_dt_data_criacao::date = :chaDtDataCriacao
        GROUP BY
            cha_tx_status""",
        nativeQuery = true)
    List<RelatorioStatusDto> relatorioPorStatus(@Param("chaDtDataCriacao")LocalDate chaDtDataCriacao);

    @Query(value = """
        SELECT
            u.usu_tx_nome AS tecnico,
            COUNT(*) AS totalChamados
        FROM
            cha_chamados c
        JOIN usu_usuarios u ON c.usu_nr_id_tecnico = u.usu_nr_id
        WHERE c.cha_dt_data_criacao::date = :chaDtDataCriacao
        GROUP BY
            u.usu_tx_nome
    """, nativeQuery = true)
    List<RelatorioChamadosPorTecnicoDto> relatorioChamadosPorTecnico(@Param("chaDtDataCriacao") LocalDate chaDtDataCriacao);

    @Query(value = """
       SELECT
            TO_CHAR(DATE_TRUNC('day', cha_dt_data_criacao), 'YYYY-MM-DD') AS data,
            TO_CHAR(DATE_TRUNC('day', cha_dt_data_criacao), 'TMDay') AS nomeDia,
            COUNT(*) AS total
       FROM
            cha_chamados
       WHERE
            cha_dt_data_criacao::date = :chaDtDataCriacao
       GROUP BY
            data,
            nomeDia
       ORDER BY
            data
    """, nativeQuery = true)
    RelatorioChamadosPorDataDto relatorioChamadosPorData(@Param("chaDtDataCriacao") LocalDate chaDtDataCriacao);

    @Query(value = """
        SELECT 
            TO_CHAR(DATE_TRUNC('week', cha_dt_data_criacao), 'YYYY-MM-DD') AS semanaInicio,
            EXTRACT(DOW FROM cha_dt_data_criacao) AS diaSemanaNumero,
            TO_CHAR(cha_dt_data_criacao, 'TMDay') AS diaSemanaNome,
            COUNT(*) AS total
        FROM cha_chamados
        GROUP BY 
            semanaInicio,
            diaSemanaNumero,
            diaSemanaNome
        ORDER BY 
            semanaInicio,
            diaSemanaNumero
        """, nativeQuery = true)
    List<ChamadoSemanalDTO> obterChamadosPorSemana();

    @Query(value = """
    SELECT
        c.cat_tx_nome AS categoria, 
        COUNT(ch.cha_nr_id) AS totalChamados
    FROM
        cha_chamados ch
    JOIN cat_categoria c ON ch.cat_nr_id = c.cat_nr_id
    WHERE
        ch.cha_dt_data_criacao::date = :chaDTDataCriacao
    GROUP BY
        c.cat_tx_nome
    ORDER BY
        totalChamados DESC
    """, nativeQuery = true)
    List<RelatorioChamadosPorCategoriaDto> relatorioChamadosPorCategoria(@Param("chaDTDataCriacao") LocalDate chaDTDataCriacao);

}
