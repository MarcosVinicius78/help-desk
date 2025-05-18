package com.br.helpdesk.repository;

import com.br.helpdesk.models.RolesEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntidade, Long> {
}
