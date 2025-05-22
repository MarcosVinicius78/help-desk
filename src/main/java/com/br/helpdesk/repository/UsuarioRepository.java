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
            upper(usu.usu_tx_email) = upper(:usuTxNome)
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
    SELECT
            usu.*
    FROM usu_usuarios usu
    where
        (:#{#filtro.rolNrId() == null} or usu.rol_nr_id =:#{#filtro.rolNrId()})
        and (:#{#filtro.usuTxNome() == null} or upper(usu.usu_tx_nome) like upper(concat('%', coalesce(:#{#filtro.usuTxNome()?.trim()}, ''), '%')))
    """
    )
    Page<UsuarioEntidade> listarUsuarios(
            @Param("filtro") UsuarioFilterForm filtro,
            Pageable pageable
    );

}
