package com.br.helpdesk.repository;

import com.br.helpdesk.models.RolesEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RolesRepository extends JpaRepository<RolesEntidade, Long> {

    RolesEntidade findByRolNrId(Long id);
}
