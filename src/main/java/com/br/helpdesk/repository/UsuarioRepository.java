package com.br.helpdesk.repository;

import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.services.usuario.form.UsuarioFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long> {

    @Query(value = """
        select
            usu.*
        from
            usu_usuarios usu
        where
            usu.usu_tx_email = :usuTxNome
    """, nativeQuery = true)
    Optional<UsuarioEntidade> buscarUsuarioPorEmail(@Param("usuTxNome") String usuTxNome);

    @Query(value = """
        select
            usu.*
        from
            usu_usuarios usu
        where
            usu.usu_tx_nome = :usuTxNome
    """, nativeQuery = true)
    Optional<UsuarioEntidade> buscarUsuarioPorNome(@Param("usuTxNome") String usuTxNome);

    @Query(
            nativeQuery = true,
            value = """
    SELECT usu.*
      FROM usu_usuarios usu
          where (:#{#filtro.rolNrId() == null} or usu.rol_nr_id =:#{#filtro.rolNrId()})
    """
    )
    Page<UsuarioEntidade> listarUsuarios(
            @Param("filtro") UsuarioFilterForm filtro,
            Pageable pageable
    );

//    and (:#{#filtro.eaNrId() == null} or mea.mea_nr_id =:#{#filtro.meaNrId})
//    and (:#{#filtro.medNrId() == null} or mea.med_nr_id =:#{#filtro.medNrId})
//    and (:#{#filtro.umeNrId() == null} or mea.ume_nr_id =:#{#filtro.umeNrId})
//    and (:#{#filtro.meaTxDescricao() == null} or upper(mea.mea_tx_descricao) like upper(concat('%', coalesce(:#{#filtro.meaTxDescricao()?.trim()}, ''), '%')))
//    and (:#{#filtro.meaTxCodigoCatmat() == null} or upper(mea.mea_tx_codigo_catmat) like upper(concat('%', coalesce(:#{#filtro.meaTxCodigoCatmat()?.trim()}, ''), '%')))
//    and (:#{#filtro.meaTxConcentracao() == null} or upper(mea.mea_tx_concentracao) like upper(concat('%', coalesce(:#{#filtro.meaTxConcentracao()?.trim()}, ''), '%')))
//    and (:#{#filtro.meaTxFormaFarmaceutica() == null} or upper(mea.mea_tx_forma_farmaceutica) like upper(concat('%', coalesce(:#{#filtro.meaTxFormaFarmaceutica()?.trim()}, ''), '%')))
//    and (:#{#filtro.meaTxVolume() == null} or upper(mea.mea_tx_volume) like upper(concat('%', coalesce(:#{#filtro.meaTxVolume()?.trim()}, ''), '%')))
//    and (:#{#filtro.meaTxDescricaoOuCatmat() == null}


}
