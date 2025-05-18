package com.br.helpdesk.repository;

import com.br.helpdesk.models.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long> {

    @Query(value = """
        select
            *
        from
            usu_usuarios
        where
            usu_tx_email = :usuTxNome
    """, nativeQuery = true)
    Optional<UsuarioEntidade> buscarUsuarioPorEmail(@Param("usuTxNome") String usuTxNome);
}
