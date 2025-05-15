package com.br.helpdesk.repository;

import com.br.helpdesk.models.CategoriaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntidade, Long> {
}
