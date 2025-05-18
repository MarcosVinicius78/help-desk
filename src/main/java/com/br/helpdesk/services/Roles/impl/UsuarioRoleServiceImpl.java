package com.br.helpdesk.services.Roles.impl;

import com.br.helpdesk.models.RolesEntidade;
import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.repository.RolesRepository;
import com.br.helpdesk.repository.UsuarioRepository;
import com.br.helpdesk.services.Roles.UsuarioRoleService;
import com.br.helpdesk.services.Roles.dto.RolesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioRoleServiceImpl implements UsuarioRoleService {

    private final UsuarioRepository usuarioRepository;
    private final RolesRepository rolesRepository;

    @Override
    public void atribuirRole(Long usuarioId, Long roleId) {
        UsuarioEntidade usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        RolesEntidade role = rolesRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role não encontrado"));

        usuario.setRolNrId(roleId);
        usuarioRepository.save(usuario);
    }

    @Override
    public void removerRole(Long usuarioId, Long roleId) {
        UsuarioEntidade usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        RolesEntidade role = rolesRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role não encontrado"));


        usuario.setRolNrId(null);
        usuarioRepository.save(usuario);
    }

    @Override
    public List<RolesDto> listarRoles() {
        return rolesRepository.findAll().stream()
                .map(RolesDto::new)
                .toList();
    }
}
