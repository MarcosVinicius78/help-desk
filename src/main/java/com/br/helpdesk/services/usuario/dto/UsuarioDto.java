package com.br.helpdesk.services.usuario.dto;

import com.br.helpdesk.models.UsuarioEntidade;

public record UsuarioDto(
        Long usuNrId,
        String usuTxNome,
        String usuTxEmail,
        Boolean usuBlAtivo,
        Long rolNrId
) {
    public UsuarioDto(UsuarioEntidade usuario) {
        this(
                usuario.getUsuNrId(),
                usuario.getUsuTxNome(),
                usuario.getUsuTxEmail(),
                usuario.getUsuBlAtivo(),
                usuario.getRolNrId()
        );
    }
}
