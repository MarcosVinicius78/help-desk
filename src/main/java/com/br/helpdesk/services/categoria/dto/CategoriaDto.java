package com.br.helpdesk.services.categoria.dto;

import com.br.helpdesk.models.CategoriaEntidade;

public record CategoriaDto(
        Long catNrId,
        String catTxNome,
        Long empNrId
) {
    public CategoriaDto(CategoriaEntidade categoria) {
        this(categoria.getCatNrId(), categoria.getCatTxNome(), categoria.getEmpNrId());
    }
}
