package com.br.helpdesk.models.chamados.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusChamados {
    ABERTO("Aberto"),
    EM_ANDAMENTO("Em Andamento"),
    RESOLVIDO("Resolvido"),
    FECHADO("Fechado");

    private String tipos;
}
