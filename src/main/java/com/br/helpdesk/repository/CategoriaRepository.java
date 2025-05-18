package com.br.helpdesk.repository;

import com.br.helpdesk.models.CategoriaEntidade;
import com.br.helpdesk.services.categoria.form.CategoriaFiltroForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaEntidade, Long> {

    @Query(nativeQuery = true,
            value = """
                select
                    cat.cat_nr_id,
                    cat.cat_tx_nome,
                    cat.emp_nr_id
                from public.cat_categoria cat
                where cat.emp_nr_id = :empNrId
                and (:#{#filtro.catNrId() == null} or cat.cat_nr_id = :#{#filtro.catNrId()})
                and (:#{#filtro.catTxNome() == null} or upper(cat.cat_tx_nome) like upper(concat('%', coalesce(:#{#filtro.catTxNome()}, ''), '%')))
            """)
    Page<CategoriaEntidade> findByEmpNrId(@Param("empNrId") Long empNrId, Pageable pageable, @Param("filtro") CategoriaFiltroForm filtro);
}