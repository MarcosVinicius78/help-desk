package com.br.helpdesk.services.usuario;

import com.br.helpdesk.services.usuario.dto.UsuarioDto;
import com.br.helpdesk.services.usuario.form.UsuarioFilterForm;
import com.br.helpdesk.services.usuario.form.UsuarioForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface UsuarioService {
    Page<UsuarioDto> listarUsuarios(UsuarioFilterForm filtro, Pageable pageable);
    UsuarioDto buscarUsuarioPorId(Long id);
    UsuarioDto criarUsuario(UsuarioForm form);
    UsuarioDto atualizarUsuario(Long id, UsuarioForm form);
    void deletarUsuario(Long id);
}
