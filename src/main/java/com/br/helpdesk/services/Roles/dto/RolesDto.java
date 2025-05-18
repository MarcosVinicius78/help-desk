package com.br.helpdesk.services.Roles.dto;

import com.br.helpdesk.models.RolesEntidade;

public record RolesDto(
        Long rolNrId,
        String rolTxDescricao
) {
    public RolesDto(RolesEntidade rolesEntidade) {
        this(
                rolesEntidade.getRolNrId(),
                rolesEntidade.getRolTxDescricao()
        );
    }
}
