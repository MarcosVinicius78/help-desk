package com.br.helpdesk.repository;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<ChamadosEntidade, Long> {
    Page<ChamadosEntidade> findByUsuNrIdCliente(Long usuNrIdCliente, Pageable pageable);

    Page<ChamadosEntidade> findByUsuNrIdTecnico(Long usuNrIdTecnico, Pageable pageable);

}
