package com.br.helpdesk.services.usuario.impl;

import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.repository.UsuarioRepository;
import com.br.helpdesk.services.usuario.UsuarioService;
import com.br.helpdesk.services.usuario.dto.UsuarioDto;
import com.br.helpdesk.services.usuario.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioDto::new)
                .toList();
    }

    @Override
    public UsuarioDto buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioDto::new)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public UsuarioDto criarUsuario(UsuarioForm form) {
        UsuarioEntidade usuario = new UsuarioEntidade();
        usuario.setUsuTxNome(form.usuTxNome());
        usuario.setUsuTxEmail(form.usuTxEmail());
        usuario.setUsuTxSenha(form.usuTxSenha());
        usuario.setUsuBlAtivo(form.usuBlAtivo());
        usuario.setRolNrId(form.rolNrId());
        return new UsuarioDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto atualizarUsuario(Long id, UsuarioForm form) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setUsuTxNome(form.usuTxNome());
                    usuario.setUsuTxEmail(form.usuTxEmail());
                    usuario.setUsuTxSenha(form.usuTxSenha());
                    usuario.setUsuBlAtivo(form.usuBlAtivo());
                    usuario.setRolNrId(form.rolNrId());
                    return new UsuarioDto(usuarioRepository.save(usuario));
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public void deletarUsuario(Long id) {
        buscarUsuarioPorId(id);
        usuarioRepository.deleteById(id);
    }
}
