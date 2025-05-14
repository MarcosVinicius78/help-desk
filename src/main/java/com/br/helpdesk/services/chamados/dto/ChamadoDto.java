package com.br.helpdesk.services.chamados.dto;

import com.br.helpdesk.models.ChamadosEntidade;

import java.time.LocalDateTime;

public record ChamadoDto(
        Long chaNrId,
        String chaTxTitulo,
        String chaTxDescricao,
        String chaTxStatus,
        LocalDateTime chaDtDataCriacao,
        LocalDateTime chaDtDataAtualizacao,
        Long chaNrIdCliente,
        Long chaNrIdTecnico
) {
    public ChamadoDto(ChamadosEntidade chamadosEntidade){
        this(
                chamadosEntidade.getChaNrId(),
                chamadosEntidade.getChaTxTitulo(),
                chamadosEntidade.getChaTxDescricao(),
                chamadosEntidade.getChaTxStatus(),
                chamadosEntidade.getChaDtDataCriacao(),
                chamadosEntidade.getChaDtDataAtualizacao(),
                chamadosEntidade.getUsuNrIdCliente(),
                chamadosEntidade.getUsuNrIdTecnico()
        );
    }
}
