package com.br.helpdesk.repository;

import com.br.helpdesk.models.ChamadosEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<ChamadosEntidade, Long> {
}
