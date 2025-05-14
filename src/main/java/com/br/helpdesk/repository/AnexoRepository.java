package com.br.helpdesk.repository;

import com.br.helpdesk.models.AnexosEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoRepository extends JpaRepository<AnexosEntidade, Long> {
}
