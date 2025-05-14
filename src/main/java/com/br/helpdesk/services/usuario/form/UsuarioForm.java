package com.br.helpdesk.services.usuario.form;

public record UsuarioForm(
        String usuTxNome,
        String usuTxEmail,
        String usuTxSenha,
        Boolean usuBlAtivo,
        Long rolNrId
) {
}
