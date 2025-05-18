package com.br.helpdesk.services.Roles;

import com.br.helpdesk.services.Roles.dto.RolesDto;

import java.util.List;

public interface UsuarioRoleService {

    void atribuirRole(Long usuarioId, Long roleId);
    void removerRole(Long usuarioId, Long roleId);
    List<RolesDto> listarRoles();

}
