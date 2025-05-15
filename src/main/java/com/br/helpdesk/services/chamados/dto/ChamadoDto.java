package com.br.helpdesk.services.chamados.dto;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.models.chamados.enums.StatusChamados;

import java.time.LocalDateTime;

public record ChamadoDto(
        Long chaNrId,
        String chaTxTitulo,
        String chaTxDescricao,
        StatusChamados chaTxStatus,
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
