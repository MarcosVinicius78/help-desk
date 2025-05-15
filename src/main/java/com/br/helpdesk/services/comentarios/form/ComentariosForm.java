package com.br.helpdesk.services.comentarios.form;

import java.time.LocalDateTime;

public record ComentariosForm(
        String comTxDescricao,
        LocalDateTime comDtDataCriacao,
        Long chaNrId,
        Long usuNrIdCliente
) {
}
