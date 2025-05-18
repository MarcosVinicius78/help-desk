package com.br.helpdesk.services.chamados.dto;

import com.br.helpdesk.models.chamados.enums.StatusChamados;

import java.time.LocalDateTime;

public record ChamadoDadosCompletosDto(
        Long chaNrId,
        String chaTxTitulo,
        String chaTxDescricao,
        String catTxNome,
        Long catNrId,
        StatusChamados chaTxStatus,
        LocalDateTime chaDtDataCriacao,
        LocalDateTime chaDtDataAtualizacao,
        Long chaNrIdCliente,
        Long chaNrIdTecnico,
        String usuTxNomeTecnico,
        String usuTxNomeCliente
) {
    public ChamadoDadosCompletosDto (ChamadosDadosCompletos chamadosDadosCompletos) {
        this(
                chamadosDadosCompletos.getChaNrId(),
                chamadosDadosCompletos.getChaTxTitulo(),
                chamadosDadosCompletos.getChaTxDescricao(),
                chamadosDadosCompletos.getCatTxNome(),
                chamadosDadosCompletos.getCatNrId(),
                chamadosDadosCompletos.getChaTxStatus(),
                chamadosDadosCompletos.getChaDtDataCriacao(),
                chamadosDadosCompletos.getChaDtDataAtualizacao(),
                chamadosDadosCompletos.getChaNrIdCliente(),
                chamadosDadosCompletos.getChaNrIdTecnico(),
                chamadosDadosCompletos.getNomeTecnico(),
                chamadosDadosCompletos.getNomeCliente()
                );
    }
}