package com.br.helpdesk.services.usuario.form;

public record UsuarioFilterForm(
        Long usuNrId,
        String usuTxNome,
        String usuTxEmail,
        Boolean usuBlAtivo,
        Long rolNrId,
        Long empNrId
) {
}
