package com.br.helpdesk.repository;

import com.br.helpdesk.models.ComentariosEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepository extends JpaRepository<ComentariosEntidade, Long> {
}
