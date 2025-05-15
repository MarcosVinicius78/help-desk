package com.br.helpdesk.services.comentarios.dto;

import com.br.helpdesk.models.ComentariosEntidade;

import java.time.LocalDateTime;

public record ComentariosDto(
        Long comNrId,
        String comTxDescricao,
        LocalDateTime comDtDataCriacao,
        Long chaNrId,
        Long usuNrIdCliente
) {
    public ComentariosDto(ComentariosEntidade comentario) {
        this(
                comentario.getComNrId(),
                comentario.getComTxDescricao(),
                comentario.getComDtDataCriacao(),
                comentario.getChaNrId(),
                comentario.getUsuNrIdCliente()
        );
    }
}
