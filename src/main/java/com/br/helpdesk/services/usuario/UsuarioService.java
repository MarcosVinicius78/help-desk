package com.br.helpdesk.services.usuario;

import com.br.helpdesk.services.usuario.dto.UsuarioDto;
import com.br.helpdesk.services.usuario.form.UsuarioForm;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> listarUsuarios();
    UsuarioDto buscarUsuarioPorId(Long id);
    UsuarioDto criarUsuario(UsuarioForm form);
    UsuarioDto atualizarUsuario(Long id, UsuarioForm form);
    void deletarUsuario(Long id);
}
