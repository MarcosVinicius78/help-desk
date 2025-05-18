package com.br.helpdesk.repository;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.services.chamados.dto.ChamadosDadosCompletos;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<ChamadosEntidade, Long> {

    @Query(nativeQuery = true,
            value = """
           select
               cha.cha_nr_id chaNrId,
               cha.cha_tx_titulo chaTxTitulo,
               cha.cha_tx_descricao chaTxDescricao,
               cha.cha_tx_status chaTxStatus,
               cha.cha_dt_data_criacao chaDtDataCriacao,
               cha.cha_dt_data_atualizacao chaDtDataAtualizacao,
               cha.usu_nr_id_cliente chaNrIdCliente,
               cha.usu_nr_id_tecnico chaNrIdTecnico,
               cha.cat_nr_id catNrId,
               cat.cat_tx_nome catTxNome,
               usu_cli.usu_tx_nome as nomeCliente,
               usu_tec.usu_tx_nome as nomeTecnico
           from public.cha_chamados cha
           left join public.cat_categoria cat on cat.cat_nr_id = cha.cat_nr_id
           left join public.usu_usuarios usu_cli on usu_cli.usu_nr_id = cha.usu_nr_id_cliente
           left join public.usu_usuarios usu_tec on usu_tec.usu_nr_id = cha.usu_nr_id_tecnico
           where (:#{#filtro.catNrId() == null} or cha.cat_nr_id = :#{#filtro.catNrId()})
           and (:#{#filtro.chaTxTitulo() == null} or upper(cha.cha_tx_titulo) like upper(concat('%', coalesce(:#{#filtro.chaTxTitulo()}, ''), '%')))
           and (:#{#filtro.chaTxDescricao() == null} or upper(cha.cha_tx_descricao) like upper(concat('%', coalesce(:#{#filtro.chaTxDescricao()}, ''), '%')))
           and (:#{#filtro.chaTxStatusStr() == null} or cha.cha_tx_status = :#{#filtro.chaTxStatusStr()})
       """)
    Page<ChamadosDadosCompletos> findAllWithFilters(
            @Param("filtro") ChamadoForm filtro,
            Pageable pageable
    );

    @Query(nativeQuery = true,
            value = """
            select
               cha.cha_nr_id chaNrId,
               cha.cha_tx_titulo chaTxTitulo,
               cha.cha_tx_descricao chaTxDescricao,
               cha.cha_tx_status chaTxStatus,
               cha.cha_dt_data_criacao chaDtDataCriacao,
               cha.cha_dt_data_atualizacao chaDtDataAtualizacao,
               cha.usu_nr_id_cliente chaNrIdCliente,
               cha.usu_nr_id_tecnico chaNrIdTecnico,
               cha.cat_nr_id catNrId,
               cat.cat_tx_nome catTxNome,
               usu_cli.usu_tx_nome as nomeCliente,
               usu_tec.usu_tx_nome as nomeTecnico
           from public.cha_chamados cha
           left join public.cat_categoria cat on cat.cat_nr_id = cha.cat_nr_id
           left join public.usu_usuarios usu_cli on usu_cli.usu_nr_id = cha.usu_nr_id_cliente
           left join public.usu_usuarios usu_tec on usu_tec.usu_nr_id = cha.usu_nr_id_tecnico
            where cha.usu_nr_id_cliente = :usuNrIdCliente
            and (:#{#filtro.catNrId() == null} or cha.cat_nr_id = :#{#filtro.catNrId()})
            and (:#{#filtro.chaTxTitulo() == null} or upper(cha.cha_tx_titulo) like upper(concat('%', coalesce(:#{#filtro.chaTxTitulo()}, ''), '%')))
            and (:#{#filtro.chaTxDescricao() == null} or upper(cha.cha_tx_descricao) like upper(concat('%', coalesce(:#{#filtro.chaTxDescricao()}, ''), '%')))
            and (:#{#filtro.chaTxStatusStr() == null} or cha.cha_tx_status = :#{#filtro.chaTxStatusStr()})
        """)
    Page<ChamadosDadosCompletos> findByUsuNrIdCliente(
            @Param("usuNrIdCliente") Long usuNrIdCliente,
            @Param("filtro") ChamadoForm filtro,
            Pageable pageable
    );

    @Query(nativeQuery = true,
            value = """
            select
               cha.cha_nr_id chaNrId,
               cha.cha_tx_titulo chaTxTitulo,
               cha.cha_tx_descricao chaTxDescricao,
               cha.cha_tx_status chaTxStatus,
               cha.cha_dt_data_criacao chaDtDataCriacao,
               cha.cha_dt_data_atualizacao chaDtDataAtualizacao,
               cha.usu_nr_id_cliente chaNrIdCliente,
               cha.usu_nr_id_tecnico chaNrIdTecnico,
               cha.cat_nr_id catNrId,
               cat.cat_tx_nome catTxNome,
               usu_cli.usu_tx_nome as nomeCliente,
               usu_tec.usu_tx_nome as nomeTecnico
           from public.cha_chamados cha
           left join public.cat_categoria cat on cat.cat_nr_id = cha.cat_nr_id
           left join public.usu_usuarios usu_cli on usu_cli.usu_nr_id = cha.usu_nr_id_cliente
           left join public.usu_usuarios usu_tec on usu_tec.usu_nr_id = cha.usu_nr_id_tecnico
            where cha.usu_nr_id_tecnico = :usuNrIdTecnico
            and (:#{#filtro.catNrId() == null} or cha.cat_nr_id = :#{#filtro.catNrId()})
            and (:#{#filtro.chaTxTitulo() == null} or upper(cha.cha_tx_titulo) like upper(concat('%', coalesce(:#{#filtro.chaTxTitulo()}, ''), '%')))
            and (:#{#filtro.chaTxDescricao() == null} or upper(cha.cha_tx_descricao) like upper(concat('%', coalesce(:#{#filtro.chaTxDescricao()}, ''), '%')))
            and (:#{#filtro.chaTxStatusStr() == null} or cha.cha_tx_status = :#{#filtro.chaTxStatusStr()})
        """)
    Page<ChamadosDadosCompletos> findByUsuNrIdTecnico(@Param("usuNrIdTecnico") Long usuNrIdTecnico, @Param("filtro") ChamadoForm filtro, Pageable pageable);

}
