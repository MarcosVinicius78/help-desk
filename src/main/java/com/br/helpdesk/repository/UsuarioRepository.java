package com.br.helpdesk.repository;

import com.br.helpdesk.models.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long> {
}
